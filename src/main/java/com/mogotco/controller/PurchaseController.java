package com.mogotco.controller;

import java.util.List;

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
import com.mogotco.service.MentoringOptionService;
import com.mogotco.service.MentoringService;
import com.mogotco.service.MentoringmemberService;
import com.mogotco.service.PurchaseDetailService;
import com.mogotco.service.PurchaseService;

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
	
	//구매페이지
	@RequestMapping("")
	public String purchase(Model model, HttpSession session, PurchaseDTO pur) {
		
		//mentoringid제외한 것
		model.addAttribute("pur", pur);
		
		//mentoringoptionid
		MentoringOptionDTO mto = null;
		try {
			mto = service4.viewmentoringoptionid(pur.getMentoring_mentoringid(), pur.getMentoringoption_mentoringtime());
			model.addAttribute("mto", mto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("center", purchase+"purchase");
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
	public String purchasefinish(Model model, HttpSession session, PurchaseDTO pur) {
		//결제완료 버튼을 눌렀을 때

		//purchase부분에 point생성
		//purchase부분 넘길때 받아올 것들
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
					pur.getPurprice(), pur.getPurpay(), pur.getPurcard(),pur.getMentoring_mtitle(), pur.getUser_mentorname(), 
					pur.getMentoring_mentoringdate(), pur.getMentoringoption_mentoringtime(), 
					mentoring.getMentorurl(), pur.getMentoring_mplace(), 0, mentoring.getMcaring());//membercount부분은 member부분에서 저장되기 때문에 굳이 detail에서 넣어줄 이유가 없음
			service1.register(detail);
			
			//해당 mentoringoption을 불러옴
			MentoringOptionDTO beforementoringoption = service4.get(pur.getMentoringoption_mentoringoptionid());
			//재고수정
			MentoringOptionDTO aftermentoringoption = new MentoringOptionDTO(pur.getMentoringoption_mentoringoptionid(), 
						pur.getMentoring_mentoringid(), pur.getMentoringoption_mentoringtime(), beforementoringoption.getMoptionstock()-1);
			service4.modify(aftermentoringoption);
			
			//point값 수정
			//session정보를 가지고와서 수정함
			
			//구매 정보 뽑음
			PurchaseDTO finish = null;
			finish=service.purchasefinishpage(r);
			//model객체에 담음
			model.addAttribute("list", finish);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("center", purchase+"purchasefinish");
		return "main";
	}

}