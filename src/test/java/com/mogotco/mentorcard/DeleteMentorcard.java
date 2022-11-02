package com.mogotco.mentorcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.MentorcardService;

@SpringBootTest
class DeleteMentorcard {

	@Autowired
	MentorcardService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(1004);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}