package com.mogotco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.MCateDTO;
import com.mogotco.dto.MentorDTO;
import com.mogotco.dto.MentoringDTO;
import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.dto.PurchaseDetailDTO;
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
	
	
	String mentoring = "mentoring/";

	// 멘토링목록
	@RequestMapping("/mentoring")
	public String mentoring(Model model, String userid) {
		List<MentoringDTO> mlist = null; // 모든 멘토링 아이템용
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		MentorDTO ment = null;
		try {
			mlist = mservice.viewMentoringAll(); // 모든 멘토링 정보 넣어주기
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			ment = mentor_service.mentorAll(userid);
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
	public String mentoringCate(Model model, String mname) {
		List<MentoringDTO> citemlist = null; // 카테고리별 리스트용
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		try {
			citemlist = mservice.selectMentoringAll(mname);// 카테고리별 멘토링 정보 넣어주기
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("selcatename", mname);
			model.addAttribute("mtr", citemlist); // 등록된 멘토링 리스트
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
	public String search(Model model, String txt, String mname) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		String all = "all";
		try {
			if (mname.equals(all)) {
				catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
				searchlist = mtmapper.mentoringsearch(txt);
				model.addAttribute("txt", txt);
				model.addAttribute("mtr", searchlist);
				model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
				model.addAttribute("center", mentoring + "mentoring");
			} else {
				catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
				searchlist = mtmapper.mcatesearch(mname, txt);
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
	public String mainsearch(Model model, String txt) {
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		List<MentoringDTO> searchlist = null;
		try {
			searchlist = mtmapper.mentoringsearch(txt);
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("mtr", searchlist);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("center", mentoring + "mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}
	
	// txt가 있을 때
	// 메인에서 카테고리, select type순서별 검색( 검색창에 text가 있을 때)
	@RequestMapping("/multimainsearch")
	public String multimainsearch(Model model, String txt, String mname, String mtype) {
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
						searchlist = mtmapper.allpricesearch(txt);
						// 리뷰
					}
					if (mtype.equals(orderreview)) {
						searchlist = mtmapper.allreviewsearch(txt);
						// 최근 멘토링
					}
					if (mtype.equals(recentmen)) {
						searchlist = mtmapper.allrecentsearch(txt);
						// 사후관리
					}
					if (mtype.equals(mcaringok)) {
						searchlist = mtmapper.allmcaringoksearch(txt, 1);
					}
				} else {
					// 기격
					if (mtype.equals(lowprice)) {
						searchlist = mtmapper.mcatepricesearch(mname, txt);
						// 리뷰
					}
					if (mtype.equals(orderreview)) {
						searchlist = mtmapper.mcatereviewsearch(mname, txt);
						// 최근 멘토링
					}
					if (mtype.equals(recentmen)) {
						searchlist = mtmapper.mcaterecentsearch(mname, txt);
						// 사후관리
					}
					if (mtype.equals(mcaringok)) {
						searchlist = mtmapper.mcatemcaringoksearch(mname, txt, 1);
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
	
	// 메인에서 카테고리, select type순서별 검색( 검색창에 text가 있을 때)
	@RequestMapping("/multimainsearch1")
	public String multimainsearch1(Model model, String mname, String mtype) {
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
						searchlist = mtmapper.nallpricesearch();
						// 리뷰
					}
					if (mtype.equals(orderreview)) {
						searchlist = mtmapper.nallreviewsearch();
						// 최근 멘토링
					}
					if (mtype.equals(recentmen)) {
						searchlist = mtmapper.nallrecentsearch();
						// 사후관리
					}
					if (mtype.equals(mcaringok)) {
						searchlist = mtmapper.nallmcaringoksearch(1);
					}
				} else {
					// 기격
					if (mtype.equals(lowprice)) {
						searchlist = mtmapper.nmcatepricesearch(mname);
						// 리뷰
					}
					if (mtype.equals(orderreview)) {
						searchlist = mtmapper.nmcatereviewsearch(mname);
						// 최근 멘토링
					}
					if (mtype.equals(recentmen)) {
						searchlist = mtmapper.nmcaterecentsearch(mname);
						// 사후관리
					}
					if (mtype.equals(mcaringok)) {
						searchlist = mtmapper.nmcatemcaringoksearch(mname, 1);
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
