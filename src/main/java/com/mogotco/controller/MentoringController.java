package com.mogotco.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.MCateDTO;
import com.mogotco.dto.MentorDTO;
import com.mogotco.dto.MentoringDTO;
import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.dto.PurchaseDTO;
import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.frame.Util;
import com.mogotco.mapper.MentoringMapper;
import com.mogotco.service.MCateService;
import com.mogotco.service.MentorService;
import com.mogotco.service.MentoringOptionService;
import com.mogotco.service.MentoringService;
import com.mogotco.service.PurchaseDetailService;

@Controller
@RequestMapping("/mentoring")
public class MentoringController {

	@Autowired
	MentoringService mservice;

	@Autowired
	MentoringOptionService moservice;

	@Autowired
	MCateService mcateservice;

	@Autowired
	MentorService mentor_service;
	
	@Autowired
	MentoringMapper mtmapper;

	@Autowired
	PurchaseDetailService service1;
	
	@Value("${admindir}")
	String admindir;

	@Value("${userdir}")
	String userdir;
	
	
	String mentoring = "mentoring/";
	
	// 페이징 처리를 위한 id값 유무 판단
	@RequestMapping("/pagingcheck")
	public void pagingcheck(HttpServletRequest request, HttpServletResponse response) {
		// current session이 없으면 없는채로 두는 것
		HttpSession session = request.getSession(false);
			try {// session이 있을 때 controller주소로 감
				
				//한국어 mname해줘야 함
				String mname = request.getParameter("mname");
				String encodeMname = URLEncoder.encode(mname, "UTF-8");

				String meningnum = request.getParameter("meningnum");
				String mtype = request.getParameter("selcatename");
				String txt = request.getParameter("txt");
				
				if(meningnum == null) {
					int meningnum1 = 0;
					meningnum = Integer.toString(meningnum1); 
					if(mtype == null) {
						if(mname == null) {
							if(txt == null) {
								//아무것도 없고 mentoring/mentoring으로 들어갔을 때
								response.sendRedirect("/mogotco/mentoring/mentoring?useridid=" +request.getParameter("userid")+"&meningnum="+meningnum);
							}else {
								//mentoring/mentoring인데 검색을 했을 때(mainsearch)
								response.sendRedirect("/mogotco/mentoring/mainsearch?txt=" +txt+"&meningnum="+meningnum);	
							}
						}else {
							//cate고리별로 검색
							if(txt==null) {
								//카테고리 자체만을 클릭 mentoring/mentoringCate
								response.sendRedirect("/mogotco/mentoring/mentoringCate?userid=" +request.getParameter("userid")+"&meningnum="+meningnum + "&mname="+mname);
								
							}else {
								//카테고리 안에서의 검색 mentoring/search
								response.sendRedirect("/mogotco/mentoring/search?txt=" +txt+"&meningnum="+meningnum+"&mname="+mname);
							}
						}
					}
					
				}else {
					
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	// 멘토링목록
	@RequestMapping("/mentoring")
	public String mentoring(Model model, String userid, Integer meningnum) {
		List<MentoringDTO> mlist = null; // 모든 멘토링 아이템용
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		MentorDTO ment = null;
		try {
			int page = 0;
			int resort= 1;
			page = page + meningnum;
			int meningnum1 = page;
			mlist = mservice.viewMentoringAll(meningnum); // 모든 멘토링 정보 넣어주기
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			ment = mentor_service.mentorAll(userid);
			//다시 paging을 0으로 맞추기 위해서
			model.addAttribute("page", page);
			model.addAttribute("meningnum", meningnum1);
			model.addAttribute("mtr", mlist); // 등록된 멘토링 리스트
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("center", mentoring+"mentoring");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}

	@RequestMapping("/mentoringCate")
	public String mentoringCate(Model model, String userid, String mname, Integer meningnum) {
		List<MentoringDTO> citemlist = null; // 카테고리별 리스트용
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		MentorDTO ment = null;
		try {
			int page = 0;
			page = page + meningnum;
			int meningnum1 = page;
			citemlist = mservice.selectMentoringAll(mname,meningnum);// 카테고리별 멘토링 정보 넣어주기
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			ment = mentor_service.mentorAll(userid);
			//다시 paging을 0으로 맞추기 위해서
			model.addAttribute("page", page);
			model.addAttribute("meningnum", meningnum1);
			model.addAttribute("selcatename", mname);
			model.addAttribute("mtr", citemlist); // 등록된 멘토링 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}

	// 멘토링상세페이지
	@RequestMapping("/mentoringdetail")
	public String mentoringdetail(Model model, int mentoringid) {
		MentoringDTO mto = null; // 멘토링 옵션용
		MentoringDTO mtg = null; // 멘토 프로필 정보용
		List<MentoringOptionDTO> mttime = null; // 멘토링별 시간 리스트용
		try {
			mto = mservice.viewMentoringOp(mentoringid); // 멘토링 옵션 정보 넣어주기
			mtg = mservice.get(mentoringid); // 멘토 프로필 정보 넣어주기
			mttime = moservice.viewMentorigTime(mentoringid); // 멘토링 시간 리스트 넣어주기
			model.addAttribute("mto", mto);
			model.addAttribute("mttime", mttime);
			model.addAttribute("mtg", mtg);
			model.addAttribute("center", mentoring + "mentoringdetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}

	// 멘토링 등록페이지
	@RequestMapping("/mentoringregister")

	public String mentoringregister(Model model, String userid) {
		MentorDTO mentorall = null;
		try {
			mentorall = mentor_service.mentorAll(userid);
			model.addAttribute("m", mentorall);
			model.addAttribute("center", mentoring+"mregister");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}

	// mentoringstart page
	@RequestMapping("/mentoringstart")
	public String mentoringstart(Model model, String id) {
		model.addAttribute("moptionid", id);
		return mentoring + "mentoringstart";
	}

	// 멘토링에서 카테고리별 검색
	@RequestMapping("/search")
	public String search(Model model, String txt, String mname, Integer meningnum) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		String all = "all";
		try {
			if (mname.equals(all)) {
				catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
				searchlist = mtmapper.mentoringsearch(txt,meningnum);
				model.addAttribute("txt", txt);
				model.addAttribute("mtr", searchlist);
				model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
				model.addAttribute("center", mentoring + "mentoring");
			} else {
				catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
				searchlist = mtmapper.mcatesearch(mname, txt, meningnum);
				model.addAttribute("mname", mname);
				model.addAttribute("txt", txt);
				model.addAttribute("mtr", searchlist);
				model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
				model.addAttribute("center", mentoring + "mentoring");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}

	// 내 멘토링 이력 보기(멘티입장 멘토링 한거)(choyunyoung add)
	@RequestMapping("/mymentoringdetail")
	public String mymentoringdetail(Model model, String id) {
		List<PurchaseDetailDTO> detail = null;
		PurchaseDetailDTO detailmember = null;
		try {
			// 비대면
			// 멘토링 정보를 불러오고
			detail = service1.wholedetail(id);
			// 향상 for문에 first라는 개별 객체에 넣어줌
			for (PurchaseDetailDTO first : detail) {
				// 멘토링 멤버수를 뽑기위해 mentoringoptionid를 불러오고
				Integer mentoringoptionid = first.getMentoringoptionid();
				// 뽑은 멤버수 정보를
				detailmember = service1.groupcount(mentoringoptionid);
				// 다시 first객체에 setting해준다.
				first.setMentoringmembercnt(detailmember.getMentoringmembercnt());
			}
			model.addAttribute("userid", id);
			model.addAttribute("list", detail);
			// 화면
			model.addAttribute("center", mentoring + "mymentoringdetail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}

	// main에서 전체검색(choyunyoung add)
	@RequestMapping("/mainsearch")
	public String mainsearch(Model model, String txt, Integer meningnum) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		try {
			searchlist = mtmapper.mentoringsearch(txt, meningnum);
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("mtr", searchlist);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}
	
	@RequestMapping("/registerimpl")
	public String register(Model model, MentoringDTO mentoringdto, String[] mentoringtime, MentoringOptionDTO mentoringoption) {
		String mtrimgname = mentoringdto.getMtrimg().getOriginalFilename();
		mentoringdto.setMentoringimg(mtrimgname);

		try {
			Util.saveMentoringFile(mentoringdto.getMtrimg(), admindir, userdir);		
			mservice.register(mentoringdto);;
			int a = mentoringdto.getMentoringid();
			int b = mentoringdto.getMmemberidcnt();
			for(int i=0;i<mentoringtime.length;i++) {
				MentoringOptionDTO mo = null;
				mo = new MentoringOptionDTO(0,a,mentoringtime[i],b);
				moservice.register(mo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}
	

	
	
	// txt가 있을 때
	// 메인에서 카테고리, select type순서별 검색( 검색창에 text가 있을 때)
	@RequestMapping("/multimainsearch")
	public String multimainsearch(Model model, String txt, String mname, String mtype, Integer meningnum) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		String all = "all";
		String lowprice = "lowprice";
		String orderreview = "orderreview";
		String recentmen = "recentmen";
		String mcaringok = "mcaringok";
		try {
				// 전체골랐을 때
				if (mname.equals(all)) {
					// 기격
					if (mtype.equals(lowprice)) {
						searchlist = mtmapper.allpricesearch(txt, meningnum);
						// 리뷰
					}
					if (mtype.equals(orderreview)) {
						searchlist = mtmapper.allreviewsearch(txt, meningnum);
						// 최근 멘토링
					}
					if (mtype.equals(recentmen)) {
						searchlist = mtmapper.allrecentsearch(txt, meningnum);
						// 사후관리
					}
					if (mtype.equals(mcaringok)) {
						searchlist = mtmapper.allmcaringoksearch(txt, 1, meningnum);
					}
				} else {
					// 기격
					if (mtype.equals(lowprice)) {
						searchlist = mtmapper.mcatepricesearch(mname, txt, meningnum);
						// 리뷰
					}
					if (mtype.equals(orderreview)) {
						searchlist = mtmapper.mcatereviewsearch(mname, txt, meningnum);
						// 최근 멘토링
					}
					if (mtype.equals(recentmen)) {
						searchlist = mtmapper.mcaterecentsearch(mname, txt, meningnum);
						// 사후관리
					}
					if (mtype.equals(mcaringok)) {
						searchlist = mtmapper.mcatemcaringoksearch(mname, txt, 1, meningnum);
					}
				
			}
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("txt", txt);
			model.addAttribute("mtr", searchlist);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}
	
	// 메인에서 카테고리, select type순서별 검색( 검색창에 text가 없 때)
	@RequestMapping("/multimainsearch1")
	public String multimainsearch1(Model model, String mname, String mtype, Integer meningnum) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		String all = "all";
		String lowprice = "lowprice";
		String orderreview = "orderreview";
		String recentmen = "recentmen";
		String mcaringok = "mcaringok";
		try {				
				if(mname.equals(all)) {
					if (mtype.equals(lowprice)) {
						searchlist = mtmapper.nallpricesearch(meningnum);
						// 리뷰
					}
					if (mtype.equals(orderreview)) {
						searchlist = mtmapper.nallreviewsearch(meningnum);
						// 최근 멘토링
					}
					if (mtype.equals(recentmen)) {
						searchlist = mtmapper.nallrecentsearch(meningnum);
						// 사후관리
					}
					if (mtype.equals(mcaringok)) {
						searchlist = mtmapper.nallmcaringoksearch(1,meningnum);
					}
				} else {
					// 기격
					if (mtype.equals(lowprice)) {
						searchlist = mtmapper.nmcatepricesearch(mname,meningnum);
						// 리뷰
					}
					if (mtype.equals(orderreview)) {
						searchlist = mtmapper.nmcatereviewsearch(mname,meningnum);
						// 최근 멘토링
					}
					if (mtype.equals(recentmen)) {
						searchlist = mtmapper.nmcaterecentsearch(mname,meningnum);
						// 사후관리
					}
					if (mtype.equals(mcaringok)) {
						searchlist = mtmapper.nmcatemcaringoksearch(mname, 1,meningnum);
					}	
				}

			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("selcatename", mname);
			model.addAttribute("mtr", searchlist);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}


}
