package com.mogotco.mentoringmember;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringmemberDTO;
import com.mogotco.service.MentoringmemberService;

@SpringBootTest
class GetMentoringmember {

	@Autowired
	MentoringmemberService service;
	
	@Test
	void contextLoads() {
		MentoringmemberDTO purchase = null;
		try {
			purchase = service.get(301);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(purchase);
	}

}
