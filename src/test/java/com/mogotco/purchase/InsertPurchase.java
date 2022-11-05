package com.mogotco.purchase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

@SpringBootTest
class InsertPurchase {

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
	
	@Test
	void contextLoads() {
		//결제완료 버튼을 눌렀을 때
		PurchaseDTO purchase = new PurchaseDTO(0, "qkrtjdgns1234", 20000, null, "네이버페이", 202, "공부법 상담 해드립니다.", null,null , "09:00", null,3 ,408);
		try {
			//구매 내용을 등록하고
			service.register(purchase);
			
			//구매한 mentoring정보를 불러옴(url을 불러오기위한 것)
			MentoringDTO mentoring = service2.get(purchase.getMentoring_mentoringid());
			
			//멘토링 멤버번호를 생성(멘토링 멤버 추가)
			MentoringmemberDTO mentoringmember = new MentoringmemberDTO(0, purchase.getMentoringoption_mentoringoptionid(), purchase.getUserid());
			service3.register(mentoringmember);
			
			//구매이력을 바로 생성
			int r = purchase.getPurchaseid();
			PurchaseDetailDTO detail = new PurchaseDetailDTO(0,purchase.getMentoringoption_mentoringoptionid(), r, 0, 0, purchase.getPurdate(), 
					purchase.getPurprice(), purchase.getPurpay(), purchase.getMentoring_mtitle(), purchase.getUser_mentorname(), 
					purchase.getMentoring_mentoringdate(), purchase.getMentoringoption_mentoringtime(), 
					mentoring.getMentorurl(), purchase.getMentoring_mplace(), 0, mentoring.getMcaring());//membercount부분은 member부분에서 저장되기 때문에 굳이 detail에서 넣어줄 이유가 없음
			service1.register(detail);
			
			//해당 mentoringoption을 불러옴
			MentoringOptionDTO beforementoringoption = service4.get(purchase.getMentoringoption_mentoringoptionid());
			//재고수정
			MentoringOptionDTO aftermentoringoption = new MentoringOptionDTO(purchase.getMentoringoption_mentoringoptionid(), 
						purchase.getMentoring_mentoringid(), purchase.getMentoringoption_mentoringtime(), beforementoringoption.getMoptionstock()-1);
			service4.modify(aftermentoringoption);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

