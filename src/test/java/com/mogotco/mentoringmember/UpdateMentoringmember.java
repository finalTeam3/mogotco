package com.mogotco.mentoringmember;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringmemberDTO;
import com.mogotco.service.MentoringmemberService;

@SpringBootTest
class UpdateMentoringmember {

	@Autowired
	MentoringmemberService service;
	
	@Test
	void contextLoads() {
		MentoringmemberDTO purchase = new MentoringmemberDTO(304, 202, "whdbsdud4321");
		try {
			service.modify(purchase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

