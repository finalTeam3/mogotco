package com.mogotco.mentoringmember;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringmemberDTO;
import com.mogotco.service.MentoringmemberService;

@SpringBootTest
class InsertMentoringmember {

	@Autowired
	MentoringmemberService service;
	
	@Test
	void contextLoads() {
		//id는 자동증가이므로 초기화값인 아무것들만 넣어주면됨
		MentoringmemberDTO purchase = new MentoringmemberDTO(0, 202, "qkrgPwjd1541");
		try {
			service.register(purchase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

