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
import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.dto.UserDTO;
import com.mogotco.frame.Util;
import com.mogotco.mapper.MentoringMapper;
import com.mogotco.service.MCateService;
import com.mogotco.service.MentorService;
import com.mogotco.service.MentoringOptionService;
import com.mogotco.service.MentoringService;
import com.mogotco.service.PurchaseDetailService;
import com.mogotco.service.UserService;

@Controller
@RequestMapping("/mentoring")
public class MentoringController {

	@Autowired
	MentoringService mservice;
	
	@Autowired
	MentorService mentorservice;

	@Autowired
	UserService uservice;

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

	// ======================검색 시작===================================
	//====================default page뿌리기=============================
	// 멘토링목록
	@RequestMapping("/defaultmentoring")
	public String defaultmentoring(Model model, String userid) {
		List<MentoringDTO> mlist = null; // 모든 멘토링 아이템용
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		MentorDTO ment = null;
		try {
			Integer meningnum = 0;
			Integer page = (meningnum + 6)/6;
			model.addAttribute("page", page);
			mlist = mservice.viewMentoringAll(meningnum); // 모든 멘토링 정보 넣어주기
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			ment = mentor_service.mentorAll(userid);
			model.addAttribute("meningnum", meningnum);
			model.addAttribute("mtr", mlist); // 등록된 멘토링 리스트
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("userid", userid);
			String txt = "null";
			String mname = "all";
			String mtype = "null";
			model.addAttribute("txt", txt);
			model.addAttribute("selcatename", mname);
			model.addAttribute("mtype", mtype);
			model.addAttribute("center", mentoring+"mentoring");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}

	@RequestMapping("/defaultmentoringCate")
	public String defaultmentoringCate(Model model,String userid, String mname) {
		List<MentoringDTO> citemlist = null; // 카테고리별 리스트용
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		MentorDTO ment = null;
		try {
			Integer meningnum = 0;
			Integer page = (meningnum + 6)/6;
			model.addAttribute("page", page);
			citemlist = mservice.selectMentoringAll(mname,meningnum);// 카테고리별 멘토링 정보 넣어주기
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			ment = mentor_service.mentorAll(userid);
			model.addAttribute("selcatename", mname);
			model.addAttribute("meningnum", meningnum);
			model.addAttribute("mtr", citemlist); // 등록된 멘토링 리스트
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("userid", userid);
			String txt = "null";
			String mtype = "null";
			model.addAttribute("txt", txt);
			model.addAttribute("mtype", mtype);
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}
	
	// 멘토링에서 카테고리별 검색
	@RequestMapping("/defaultsearch")
	public String defaultsearch(Model model, String userid,String txt, String mname) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		MentorDTO ment = null;
		String all = "all";
		try {
			
			ment = mentor_service.mentorAll(userid);
			Integer meningnum = 0;
			Integer page = (meningnum + 6)/6;
			model.addAttribute("page", page);
			if (mname.equals(all)) {
				catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
				searchlist = mtmapper.mentoringsearch(txt,meningnum);
				model.addAttribute("selcatename", mname);

			} else {
				catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
				searchlist = mtmapper.mcatesearch(mname, txt,meningnum);
				model.addAttribute("selcatename", mname);
			}
			model.addAttribute("txt", txt);
			model.addAttribute("mtr", searchlist);
			model.addAttribute("meningnum", meningnum);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("userid", userid);
			String mtype = "null";
			model.addAttribute("mtype", mtype);
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}
	
	// main에서 전체검색(choyunyoung add)
	@RequestMapping("/defaultmainsearch")
	public String defaultmainsearch(Model model, String userid,String txt) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		MentorDTO ment = null;
		try {
			Integer meningnum = 0;
			Integer page = (meningnum + 6)/6;
			model.addAttribute("page", page);
			searchlist = mtmapper.mentoringsearch(txt,meningnum);
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			ment = mentor_service.mentorAll(userid);
			model.addAttribute("mtr", searchlist);
			model.addAttribute("meningnum", meningnum);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("userid", userid);
			model.addAttribute("txt", txt);
			String mname = "all";
			String mtype = "null";
			model.addAttribute("selcatename", mname);
			model.addAttribute("mtype", mtype);
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}
	
	// txt가 있을 때
	// 메인에서 카테고리, select type순서별 검색( 검색창에 text가 있을 때)
	@RequestMapping("/defaultmultimainsearch")
	public String defaultmultimainsearch(Model model, String userid,String txt, String mname, String mtype) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		MentorDTO ment = null;
		String all = "all";
		String lowprice = "lowprice";
		String orderreview = "orderreview";
		String recentmen = "recentmen";
		String mcaringok = "mcaringok";
		try {
			ment = mentor_service.mentorAll(userid);
			Integer meningnum = 0;
				// 전체골랐을 때
				if (mname.equals(all)) {
					// 기격
					if (mtype.equals(lowprice)) {
						searchlist = mtmapper.allpricesearch(txt,meningnum);
						// 리뷰
					}
					if (mtype.equals(orderreview)) {
						searchlist = mtmapper.allreviewsearch(txt,meningnum);
						// 최근 멘토링
					}
					if (mtype.equals(recentmen)) {
						searchlist = mtmapper.allrecentsearch(txt,meningnum);
						// 사후관리
					}
					if (mtype.equals(mcaringok)) {
						searchlist = mtmapper.allmcaringoksearch(txt, 1,meningnum);
					}
					model.addAttribute("selcatename", mname);
				} else {
					// 기격
					if (mtype.equals(lowprice)) {
						searchlist = mtmapper.mcatepricesearch(mname, txt,meningnum);
						// 리뷰
					}
					if (mtype.equals(orderreview)) {
						searchlist = mtmapper.mcatereviewsearch(mname, txt,meningnum);
						// 최근 멘토링
					}
					if (mtype.equals(recentmen)) {
						searchlist = mtmapper.mcaterecentsearch(mname, txt,meningnum);
						// 사후관리
					}
					if (mtype.equals(mcaringok)) {
						searchlist = mtmapper.mcatemcaringoksearch(mname, txt, 1,meningnum);
					}
					model.addAttribute("selcatename", mname);
				
			}
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			Integer page = (meningnum + 6)/6;
			model.addAttribute("page", page);
			model.addAttribute("mtype", mtype);
			model.addAttribute("txt", txt);
			model.addAttribute("meningnum", meningnum);
			model.addAttribute("mtr", searchlist);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("userid", userid);
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}
	
	// 메인에서 카테고리, select type순서별 검색( 검색창에 text가 없을 때)
	@RequestMapping("/defaultmultimainsearch1")
	public String defaultmultimainsearch1(Model model,String userid,String mname, String mtype) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		MentorDTO ment = null;
		String all = "all";
		String lowprice = "lowprice";
		String orderreview = "orderreview";
		String recentmen = "recentmen";
		String mcaringok = "mcaringok";
		try {
			ment = mentor_service.mentorAll(userid);
			Integer meningnum = 0;
			Integer page = (meningnum + 6)/6;
			model.addAttribute("page", page);
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
					model.addAttribute("selcatename", mname);
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
					model.addAttribute("selcatename", mname);
				}

			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("mtype", mtype);
			model.addAttribute("mtr", searchlist);
			model.addAttribute("meningnum", meningnum);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("userid", userid);
			String txt = "null";
			model.addAttribute("txt", txt);
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}
	
	//====================default page 끝=============================

	// 페이징 처리를 위한 id값 유무 판단
	@RequestMapping("/pagingcheck")
	public void pagingcheck(HttpServletRequest request, HttpServletResponse response, Integer meningnum, String userid, String txt, String mtype, String mname) {
		// current session이 없으면 없는채로 두는 것
		HttpSession session = request.getSession(false);
		try {// session이 있을 때 controller주소로 감
			String null1 = "null";
			String all = "all";
			String encodetxt = URLEncoder.encode(txt, "UTF-8");
			String encodemname = URLEncoder.encode(mname, "UTF-8");
			if(txt.equals(null1)) {
				if(mtype.equals(null1)) {
					if(mname.equals(all)) {
						// 아무것도 없고 mentoring/mentoring으로 들어갔을 때
						response.sendRedirect("/mogotco/mentoring/mentoring?userid="
								+ userid + "&meningnum=" + meningnum);
					}else {
						// 카테고리 자체만을 클릭 mentoring/mentoringCate
						response.sendRedirect(
								"/mogotco/mentoring/mentoringCate?userid=" + userid
										+ "&meningnum=" + meningnum + "&mname=" + encodemname);
					}
					
				}else {
					// cate와 type둘다 선택되었을 때 mentoring/multimainsearch1
					response.sendRedirect("/mogotco/mentoring/multimainsearch1?mtype=" + mtype + "&meningnum="
							+ meningnum + "&mname=" + encodemname + "&userid=" + userid);
				}
			}else {
				if(mtype.equals(null1)) {
					if(mname.equals(all)) {
						// mentoring/mentoring인데 검색을 했을 때(mainsearch)
						response.sendRedirect(
								"/mogotco/mentoring/mainsearch?txt=" + encodetxt + "&meningnum=" + meningnum + "&userid=" + userid);
					}else {
						// 카테고리 안에서의 검색 mentoring/search
						response.sendRedirect("/mogotco/mentoring/search?txt=" + encodetxt + "&meningnum="
								+ meningnum + "&mname=" + encodemname + "&userid=" + userid);
					}
				}else {
					// txt가 있고 cate와 type둘다 선택되었을 때 mentoring/multimainsearch
					response.sendRedirect("/mogotco/mentoring/multimainsearch?txt=" + encodetxt + "&meningnum="
							+ meningnum + "&mname=" + encodemname + "&mtype=" + mtype + "&userid=" + userid);	
				}
				
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

			mlist = mservice.viewMentoringAll(meningnum); // 모든 멘토링 정보 넣어주기
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			ment = mentor_service.mentorAll(userid);
			// 다시 paging을 0으로 맞추기 위해서
			Integer page = (meningnum + 6)/6;
			model.addAttribute("page", page);
			model.addAttribute("meningnum", meningnum);
			model.addAttribute("mtr", mlist); // 등록된 멘토링 리스트
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("userid", userid);
			String txt = "null";
			String mname = "all";
			String mtype = "null";
			model.addAttribute("txt", txt);
			model.addAttribute("selcatename", mname);
			model.addAttribute("mtype", mtype);
			model.addAttribute("center", mentoring + "mentoring");

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
			Integer page = (meningnum + 6)/6;
			model.addAttribute("page", page);
			citemlist = mservice.selectMentoringAll(mname, meningnum);// 카테고리별 멘토링 정보 넣어주기
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			ment = mentor_service.mentorAll(userid);
			// 다시 paging을 0으로 맞추기 위해서
			model.addAttribute("meningnum", meningnum);
			model.addAttribute("selcatename", mname);
			model.addAttribute("mtr", citemlist); // 등록된 멘토링 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("userid", userid);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			String txt = "null";
			String mtype = "null";
			model.addAttribute("txt", txt);
			model.addAttribute("mtype", mtype);
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}

	// 멘토링에서 카테고리별 검색
	@RequestMapping("/search")
	public String search(Model model,String userid, String txt, String mname, Integer meningnum) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		String all = "all";
		MentorDTO ment = null;
		try {
			ment = mentor_service.mentorAll(userid);
			if (mname.equals(all)) {
				catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
				searchlist = mtmapper.mentoringsearch(txt, meningnum);
				model.addAttribute("selcatename", mname);

			} else {
				catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
				searchlist = mtmapper.mcatesearch(mname, txt, meningnum);
				model.addAttribute("selcatename", mname);
			}
			Integer page = (meningnum + 6)/6;
			model.addAttribute("page", page);
			model.addAttribute("meningnum", meningnum);
			model.addAttribute("txt", txt);
			model.addAttribute("mtr", searchlist);
			model.addAttribute("ms", ment);
			model.addAttribute("userid", userid);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			String mtype = "null";
			model.addAttribute("mtype", mtype);
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}

	// main에서 전체검색(choyunyoung add)
	@RequestMapping("/mainsearch")
	public String mainsearch(Model model, String userid,String txt, Integer meningnum) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		MentorDTO ment = null;
		try {
			Integer page = (meningnum + 6)/6;
			model.addAttribute("page", page);
			ment = mentor_service.mentorAll(userid);
			searchlist = mtmapper.mentoringsearch(txt, meningnum);
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("meningnum", meningnum);
			model.addAttribute("txt", txt);
			model.addAttribute("mtr", searchlist);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("userid", userid);
			String mname = "all";
			String mtype = "null";
			model.addAttribute("selcatename", mname);
			model.addAttribute("mtype", mtype);
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}

	// txt가 있을 때
	// 메인에서 카테고리, select type순서별 검색( 검색창에 text가 있을 때)
	@RequestMapping("/multimainsearch")
	public String multimainsearch(Model model,String userid, String txt, String mname, String mtype, Integer meningnum) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		MentorDTO ment = null;
		String all = "all";
		String lowprice = "lowprice";
		String orderreview = "orderreview";
		String recentmen = "recentmen";
		String mcaringok = "mcaringok";
		try {
			ment = mentor_service.mentorAll(userid);
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
				model.addAttribute("selcatename", mname);
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
				model.addAttribute("selcatename", mname);
			}
			Integer page = (meningnum + 6)/6;
			model.addAttribute("page", page);
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("meningnum", meningnum);
			model.addAttribute("txt", txt);
			model.addAttribute("mtype", mtype);
			model.addAttribute("mtr", searchlist);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("userid", userid);
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}

	// 메인에서 카테고리, select type순서별 검색( 검색창에 text가 없 때)
	@RequestMapping("/multimainsearch1")
	public String multimainsearch1(Model model,String userid, String mname, String mtype, Integer meningnum) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		MentorDTO ment = null;
		String all = "all";
		String lowprice = "lowprice";
		String orderreview = "orderreview";
		String recentmen = "recentmen";
		String mcaringok = "mcaringok";
		try {
			ment = mentor_service.mentorAll(userid);
			if (mname.equals(all)) {
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
					searchlist = mtmapper.nallmcaringoksearch(1, meningnum);
				}
				model.addAttribute("selcatename", mname);
			} else {
				// 기격
				if (mtype.equals(lowprice)) {
					searchlist = mtmapper.nmcatepricesearch(mname, meningnum);
					// 리뷰
				}
				if (mtype.equals(orderreview)) {
					searchlist = mtmapper.nmcatereviewsearch(mname, meningnum);
					// 최근 멘토링
				}
				if (mtype.equals(recentmen)) {
					searchlist = mtmapper.nmcaterecentsearch(mname, meningnum);
					// 사후관리
				}
				if (mtype.equals(mcaringok)) {
					searchlist = mtmapper.nmcatemcaringoksearch(mname, 1, meningnum);
				}
				model.addAttribute("selcatename", mname);
			}
			Integer page = (meningnum + 6)/6;
			model.addAttribute("page", page);
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("meningnum", meningnum);
			model.addAttribute("mtype", mtype);
			model.addAttribute("mtr", searchlist);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("ms", ment);
			model.addAttribute("userid", userid);
			String txt = "null";
			model.addAttribute("txt", txt);
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}

	// ======================검색 끝===================================

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
			model.addAttribute("center", mentoring + "mregister");
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

	@RequestMapping("/registerimpl")
	public String register(Model model, MentoringDTO mentoringdto, String[] mentoringtime,
			MentoringOptionDTO mentoringoption) {
		String mtrimgname = mentoringdto.getMtrimg().getOriginalFilename();
		mentoringdto.setMentoringimg(mtrimgname);

		try {
			Util.saveMentoringFile(mentoringdto.getMtrimg(), admindir, userdir);
			mservice.register(mentoringdto);
			;
			int a = mentoringdto.getMentoringid();
			int b = mentoringdto.getMmemberidcnt();
			for (int i = 0; i < mentoringtime.length; i++) {
				MentoringOptionDTO mo = null;
				mo = new MentoringOptionDTO(0, a, mentoringtime[i], b);
				moservice.register(mo);
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
		MentorDTO mentor = null;
		UserDTO myuser = null;
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
			myuser = uservice.get(id);
			mentor = mentorservice.mentorAll(id);
			model.addAttribute("userid", id);
			model.addAttribute("us", myuser);
			model.addAttribute("ms", mentor);
			model.addAttribute("list", detail);
			// 화면
			model.addAttribute("center", mentoring + "mymentoringdetail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}

}
