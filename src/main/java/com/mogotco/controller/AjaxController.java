package com.mogotco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


@RestController
public class AjaxController {
	
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

	@RequestMapping("/importsuccess")
	public Object importsuccess() {
		return "";
	}
	@RequestMapping("/kgorder")
	public Object kgorder(PurchaseDTO pur) {
		//결제완료 버튼을 눌렀을 때
		System.out.println(pur);
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
					pur.getPurprice(), pur.getPurpay(), pur.getMentoring_mtitle(), pur.getUser_mentorname(), 
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
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return "";
	}
	
	//userpoint(data저장이 안될 때)
	@RequestMapping("/pointcount")
	public Object pointcount(Integer total_price,Integer writepoint) {
		Integer modiprice =0;
		modiprice=total_price-writepoint;
		return modiprice;
	}
	
}