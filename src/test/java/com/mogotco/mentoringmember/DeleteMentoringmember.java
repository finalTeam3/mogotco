package com.mogotco.mentoringmember;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.MentoringmemberService;

@SpringBootTest
class DeleteMentoringmember {

	@Autowired
	MentoringmemberService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(304);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}