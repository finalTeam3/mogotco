package com.mogotco.controller;

import java.io.IOException;
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
import com.mogotco.dto.MWishcateDTO;
import com.mogotco.dto.MentorDTO;
import com.mogotco.dto.MentoringDTO;
import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.dto.MentoringmemberDTO;
import com.mogotco.dto.ReviewDTO;
import com.mogotco.dto.UserDTO;
import com.mogotco.frame.Util;
import com.mogotco.service.MCateService;
import com.mogotco.service.MWishcateService;
import com.mogotco.service.MentorService;
import com.mogotco.service.MentoringOptionService;
import com.mogotco.service.MentoringService;
import com.mogotco.service.MentoringmemberService;
import com.mogotco.service.ReviewService;
import com.mogotco.service.UserService;

@Controller
@RequestMapping("/mentor")
public class MentorController {

	String mentor = "mentor/";

	@Autowired
	MentorService mservice;

	@Autowired
	MentoringService mtiservice;

	@Autowired
	UserService uservice;

	@Autowired
	MWishcateService mwservice;
	
	@Autowired
	MentoringOptionService moservice;
	
	@Autowired
	ReviewService review_service;

	@Autowired
	MentoringmemberService mmservice;
	
	@Autowired
	MCateService mcateservice;
	
	@Value("${admindir}")
	String admindir;

	@Value("${userdir}")
	String userdir;

	// 아이디값 유무 판단
	@RequestMapping("/idcheck")
	public void idcheck(Integer mentorid, HttpServletRequest request, HttpServletResponse response) {
		// current session이 없으면 없는채로 두는 것
		HttpSession session = request.getSession(false);
		// session정보가 없을 때
		if (session == null) {
			try {
				// session이 없을 때 controller주소로 감
				response.sendRedirect("/mogotco/mentor/nonid?mentorid=" + mentorid);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {// session이 있을 때 controller주소로 감
				response.sendRedirect("/mogotco/mentor/mentordetail?mentorid=" + mentorid);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 멘토 listpage
	@RequestMapping("/mentorlist")
	public String mentorlist(Model model, String userid) {
		List<MentorDTO> mentorlist = null;
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		try {
			mentorlist = mservice.get();
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("list", mentorlist);
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("center", mentor + "mentorlist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}
	
	//mentor cate별로 뽑기
	@RequestMapping("/mentoringCate")
	public String mentoringCate(Model model, String mname) {
		List<MWishcateDTO> citemlist = null; // 카테고리별 리스트용
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		try {
			citemlist = mwservice.mwcatelsiList(mname);// 카테고리별 멘토링 정보 넣어주기
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("selcatename", mname);
			model.addAttribute("list", citemlist); // 등록된 mentor 리스트
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("center", mentor + "mentorlist");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}
	
	//mentor의 mentoringlist
	@RequestMapping("/mentormentoring")
	public String mentormentoring(Model model, int mentorid, String userid) {
		List<MentorDTO> citemlist = null; // 카테고리별 리스트용
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		try {
			citemlist = mservice.mentormentoring(mentorid);// 카테고리별 멘토링 정보 넣어주기
			//catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			//model.addAttribute("selcatename", mname);
			model.addAttribute("mentorid", mentorid);
			model.addAttribute("userid", userid);
			model.addAttribute("list", citemlist); // 등록된 mentor 리스트
			model.addAttribute("center", mentor + "mentormentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}
	

	// 멘토 상세페이지
	@RequestMapping("/mentordetail")
	public String mentordetail(Model model, Integer mentorid) {
		MentorDTO mta = null;
		MentorDTO mtlist = null;
		List<MWishcateDTO> mwclist = null;
		List<ReviewDTO> rlist= null; // 해당 멘토 리뷰 노출_혜정
		ReviewDTO review, reviewcount, starcnt= null;// 해당 멘토 평균 별점, 리뷰갯수_혜정
		try {
			mta = mservice.get(mentorid);
			mtlist = mservice.mentoritem1(mentorid);
			mwclist = mwservice.mwcate(mentorid);
			model.addAttribute("mentorid", mentorid);
			model.addAttribute("mta", mta);
			model.addAttribute("mtlist", mtlist);
			model.addAttribute("mwclist", mwclist);
			model.addAttribute("center", mentor + "mentordetail");
			
			// 해당 멘토의 리뷰리스트 조회_혜정
			rlist = review_service.getmentorreview(mentorid);
			model.addAttribute("mentorreview", rlist);
			// 해당 멘토의 평균 별점_혜정
			review = review_service.indivirating(mentorid);
			model.addAttribute("avgrating", review);
			// 해당 멘토의 리뷰 개수_혜정
			reviewcount = review_service.reviewcnt(mentorid);
			model.addAttribute("reviewcnt", reviewcount);
			// 별점 별 리뷰 갯수
			starcnt = review_service.starcnt(mentorid);
			model.addAttribute("starcnt", starcnt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}

	// 비회원 멘토 상세 페이지
	@RequestMapping("/nonid")
	public String nonid(Model model, int mentorid) {
		MentorDTO mta = null;
		MentorDTO mtlist = null;
		List<MWishcateDTO> mwclist = null;
		List<ReviewDTO> rlist= null; // 해당 멘토 리뷰 노출_혜정
		ReviewDTO review, reviewcount= null;// 해당 멘토 평균 별점, 리뷰 갯수_혜정
		try {
			mta = mservice.get(mentorid);
			mtlist = mservice.mentoritem1(mentorid);
			mwclist = mwservice.mwcate(mentorid);
			model.addAttribute("mentorid", mentorid);
			model.addAttribute("mta", mta);
			model.addAttribute("mtlist", mtlist);
			model.addAttribute("mwclist", mwclist);
			model.addAttribute("center", mentor + "mentordetail1");
			
			// 해당 멘토의 리뷰리스트 조회_혜정
			rlist = review_service.getmentorreview(mentorid);
			model.addAttribute("mentorreview", rlist);
			// 해당 멘토의 평균 별점_혜정
			review = review_service.indivirating(mentorid);
			model.addAttribute("avgrating", review);
			// 해당 멘토의 리뷰 개수_혜정
			reviewcount = review_service.reviewcnt(mentorid);
			model.addAttribute("reviewcnt", reviewcount);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}

	// 멘토 수정페이지
	@RequestMapping("/mentormodify")
	public String mentormodify(Model model, String id) {
		MentorDTO mentorall = null;
		try {
			mentorall = mservice.mentorAll(id);
			model.addAttribute("m", mentorall);
			model.addAttribute("center", mentor + "mentormodify");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}

	// 멘토 정보 업데이트 기능
	@RequestMapping("/modifyimpl")
	public String update(Model model, MentorDTO mentordto, Integer[] mcateid, MWishcateDTO mwishcate) {

		String mpimgname = mentordto.getMpimg().getOriginalFilename();
		mentordto.setMentorimg(mpimgname);

		String mcimgname = mentordto.getMcimg().getOriginalFilename();
		mentordto.setMcardimg(mcimgname);

		try {
			Util.saveMentorFile(mentordto.getMpimg(), mentordto.getMcimg(), admindir, userdir);
			mservice.modify(mentordto);
			int r = mentordto.getMentorid();
			mwservice.remove(r);
			for(int i=0;i<mcateid.length;i++) {
				MWishcateDTO mw = null;
				mw = new MWishcateDTO(0,mcateid[i],r,null,null,null,null,null);
				mwservice.register(mw);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:mentormodify?id=" + mentordto.getUserid();
	}

	// 멘토 등록페이지
	@RequestMapping("/mentorregister")
	public String mentorregister(Model model, String id) {
		UserDTO user = null;
		try {
			user = uservice.get(id);
			model.addAttribute("u", user);
			model.addAttribute("center", mentor + "mentorregister");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}

	// 멘토 정보 등록 기능 (멘토 지원)
	@RequestMapping("/registerimpl")
	public String register(Model model, MentorDTO mentordto, Integer[] mcateid, MWishcateDTO mwishcate) {

		String mpimgname = mentordto.getMpimg().getOriginalFilename();
		mentordto.setMentorimg(mpimgname);

		String mcimgname = mentordto.getMcimg().getOriginalFilename();
		mentordto.setMcardimg(mcimgname);

		try {
			Util.saveMentorFile(mentordto.getMpimg(), mentordto.getMcimg(), admindir, userdir);
			mservice.register(mentordto);
			int r = mentordto.getMentorid();
			for(int i=0;i<mcateid.length;i++) {
				MWishcateDTO mw = null;
				mw = new MWishcateDTO(0,mcateid[i],r,null,null,null,null,null);
				mwservice.register(mw);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:mentorregister?id="+mentordto.getUserid();
	}
	
	// 멘토링 관리자 페이지
	@RequestMapping("/mentoringadmin")
	public String mentoringadmin(Model model, int mentorid) {
		List<MentorDTO> mtlist = null;
		try {
			mtlist = mservice.mentoritem(mentorid);
			model.addAttribute("mtlist", mtlist);
			model.addAttribute("center", mentor + "mentoringadmin");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}
	
	// ocrtest 페이지
	@RequestMapping("/ocrpage")
	public String ocrpage(Model model) {
		
		model.addAttribute("center", mentor+"ocrpage");
		return "main";
	}
	
	// 멘토링 관리자 상세페이지
	@RequestMapping("/mentoringadmindetail")
	public String mentoringadmindetail(Model model, int mentoringid) {
		MentoringDTO mti = null;
		List<MentoringOptionDTO> molist = null;
		try {
			mti = mtiservice.get(mentoringid);
			molist = moservice.viewMentorigTime(mentoringid);
			model.addAttribute("mti", mti);
			model.addAttribute("molist",molist);
			model.addAttribute("center", mentor+"mentoringadmindetail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "main";
	}
	
	// 멘토링 관리자 페이지의 시간별 멘토링 멤버 목록 페이지
	@RequestMapping("/mentoringmember")
	public String mentoringmember(Model model, int mentoringid, int mentoringoptionid) {
		MentoringDTO mti = null;
		List<MentoringOptionDTO> molist = null;
		List<MentoringmemberDTO> mmlist = null;
		try {
			mti = mtiservice.get(mentoringid);
			molist = moservice.viewMentorigTime(mentoringid);
			mmlist = mmservice.mmemberuserid(mentoringoptionid);
			model.addAttribute("mti", mti);
			model.addAttribute("molist",molist);
			model.addAttribute("mmlist",mmlist);
			model.addAttribute("center", mentor+"mentoringmember");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}
	
}
