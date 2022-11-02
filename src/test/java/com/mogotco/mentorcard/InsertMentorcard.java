package com.mogotco.mentorcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentorcardDTO;
import com.mogotco.service.MentorcardService;

@SpringBootTest
class InsertMentorcard {

	@Autowired
	MentorcardService service;
	
	@Test
	void contextLoads() {
		MentorcardDTO mentorcard = new MentorcardDTO(0, 104, "E회사", "user05", "부장");
		try {
			service.register(mentorcard);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

