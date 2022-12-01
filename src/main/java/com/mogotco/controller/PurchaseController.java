package com.mogotco.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.dto.MentoringmemberDTO;
import com.mogotco.dto.PurchaseDTO;
import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.dto.UserDTO;
import com.mogotco.service.MentoringOptionService;
import com.mogotco.service.MentoringService;
import com.mogotco.service.MentoringmemberService;
import com.mogotco.service.PurchaseDetailService;
import com.mogotco.service.PurchaseService;
import com.mogotco.service.UserService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	String purchase = "purchase/";
	
	//service
	@Autowired
	PurchaseService service;
	
	@Autowired
	PurchaseDetailService service1;
	
	@Autowired
	MentoringService service2;
	
	@Autowired
	MentoringmemberService service3;
	
	@Autowired
	MentoringOptionService service4;
	
	@Autowired
	UserService service5;
	
	// 아이디값 유무 판단
	@RequestMapping("/idcheck")
	public void idcheck(PurchaseDTO purchase, HttpServletRequest request, HttpServletResponse response) {
		// current session이 없으면 없는채로 두는 것
		HttpSession session = request.getSession(false);
		// session정보가 없을 때
		if (session == null) {
			try {
				// session이 없을 때 controller주소로 감
				response.sendRedirect("/mogotco/user/login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {// session이 있을 때 controller주소로 감
				
				//한국어 encode해줘야 함
				String mentoring_mtitle = request.getParameter("mentoring_mtitle");
				String encodeMentoring_mtitle = URLEncoder.encode(mentoring_mtitle, "UTF-8");

				String mentoring_mplace = request.getParameter("mentoring_mplace");
				String encodeMentoring_mplace = URLEncoder.encode(mentoring_mplace, "UTF-8");

				response.sendRedirect("/mogotco/purchase?mentoring_mentoringid=" +request.getParameter("mentoring_mentoringid")+"&mentoringoption_mentoringtime="+request.getParameter("mentoringoption_mentoringtime")
				+ "&mentoring_mtitle="+encodeMentoring_mtitle + "&mentoring_mentoringdate="+request.getParameter("mentoring_mentoringdate") + "&mentoring_mplace="+encodeMentoring_mplace
				+ "&mentoring_mentoringprice="+request.getParameter("mentoring_mentoringprice") + "&mentor_userid="+request.getParameter("mentor_userid"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//구매페이지
	@RequestMapping("")
	public String purchase(Model model, HttpSession session,PurchaseDTO pur) {
		//mentoringid제외한 것
		model.addAttribute("pur", pur);
		
		//mentoringoptionid
		MentoringOptionDTO mto = null;
		try {
			mto = service4.viewmentoringoptionid(pur.getMentoring_mentoringid(), pur.getMentoringoption_mentoringtime());
			System.out.println(mto);
			model.addAttribute("mto", mto);
			model.addAttribute("center", purchase+"purchase");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("center", purchase+"error");
		}
		return "main";
	}
	
	//구매상세페이지
	@RequestMapping("/purchasedetail")
	public String purchasedetail(Model model, String id) {
		List<PurchaseDetailDTO> detail = null;
		PurchaseDetailDTO detailmember = null;
		try {
			//멘토링 정보를 불러오고
			detail = service1.wholedetail(id);
			//향상 for문에 first라는 개별 객체에 넣어줌
			for(PurchaseDetailDTO first : detail) {
				//멘토링 멤버수를 뽑기위해 mentoringoptionid를 불러오고
				Integer mentoringoptionid = first.getMentoringoptionid();
				//뽑은 멤버수 정보를
				detailmember = service1.groupcount(mentoringoptionid);
				//다시 first객체에 setting해준다.
				first.setMentoringmembercnt(detailmember.getMentoringmembercnt());
			}
			model.addAttribute("userid", id);
			model.addAttribute("list", detail);
			model.addAttribute("center", purchase+"purchasedetail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("center", purchase+"error");
		}
		return "main";
	}

	//구매완료페이지
	@RequestMapping("/purchasefinish")
	public String purchasefinish(Model model, HttpSession session, PurchaseDTO pur, int willusepoint, int mentoringprice) {
		//결제완료 버튼을 눌렀을 때
		try {
			//구매 내용을 등록하고
			service.register(pur);
			
			//구매한 mentoring정보를 불러옴(url을 불러오기위한 것)
			MentoringDTO mentoring = service2.get(pur.getMentoring_mentoringid());
			
			//멘토링 멤버번호를 생성(멘토링 멤버 추가)
			MentoringmemberDTO mentoringmember = new MentoringmemberDTO(0, pur.getMentoringoption_mentoringoptionid(), pur.getUserid());
			service3.register(mentoringmember);
			
			//구매이력을 바로 생성
			int r = pur.getPurchaseid();
			PurchaseDetailDTO detail = new PurchaseDetailDTO(0,pur.getMentoringoption_mentoringoptionid(), r, 0, "x", pur.getPurdate(), 
					pur.getPurprice(), pur.getPurpay(), pur.getPurcard(),pur.getMentoring_mtitle(), pur.getMentor_userid(), pur.getUser_mentorname(), 
					pur.getMentoring_mentoringdate(), pur.getMentoringoption_mentoringtime(), 
					mentoring.getMentorurl(), pur.getMentoring_mplace(), 0, mentoring.getMcaring(), mentoring.getMentorid());//membercount부분은 member부분에서 저장되기 때문에 굳이 detail에서 넣어줄 이유가 없음
			service1.register(detail);
			
			//해당 mentoringoption을 불러옴
			MentoringOptionDTO beforementoringoption = service4.get(pur.getMentoringoption_mentoringoptionid());
			//재고수정
			MentoringOptionDTO aftermentoringoption = new MentoringOptionDTO(pur.getMentoringoption_mentoringoptionid(), 
						pur.getMentoring_mentoringid(), pur.getMentoringoption_mentoringtime(), beforementoringoption.getMoptionstock()-1);
			service4.modify(aftermentoringoption);
			
			//point값 수정
			//지금 로그인된 회원 정보
			UserDTO beforeuser = null;
			beforeuser = service5.get(pur.getUserid());

			//수정 point
			int modipoint = 0;
			if(pur.getPurprice() >=30000) {
				modipoint = beforeuser.getUserpoint() - willusepoint + (mentoringprice*3/100);
			}else {
				modipoint = beforeuser.getUserpoint() - willusepoint + mentoringprice/100;
			}

			//수정할 회원 정보
			UserDTO afteruser = new UserDTO(beforeuser.getUserid(), beforeuser.getUserpwd(), beforeuser.getUsername(), beforeuser.getUseraddr(), beforeuser.getUsertel(), beforeuser.getUseremail(), 
					beforeuser.getUserdate(), beforeuser.getWithdraw(), beforeuser.getUserbirth(), modipoint, beforeuser.getNaverid(), beforeuser.getKakaoid(), beforeuser.getGoogleid(), beforeuser.getUsergen(), 
					beforeuser.getAddrnum(), beforeuser.getAddrdetail(), beforeuser.getAddrextra(), beforeuser.getSnsinsta(), beforeuser.getSnsgit(), beforeuser.getMentor_mentorok());
			//수정
			service5.modify(afteruser);
			
			//구매 정보 뽑음
			PurchaseDTO finish = null;
			finish=service.purchasefinishpage(r);
			//model객체에 담음
			model.addAttribute("list", finish);
			
			//화면
			model.addAttribute("center", purchase+"purchasefinish");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("center", purchase+"error");
		}
		return "main";
	}

}