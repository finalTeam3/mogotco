package com.mogotco.mentorcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentorcardDTO;
import com.mogotco.service.MentorcardService;

@SpringBootTest
class GetMentorcard {

	@Autowired
	MentorcardService service;
	
	@Test
	void contextLoads() {
		MentorcardDTO mentorcard = null;
		try {
			mentorcard = service.get(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mentorcard);
	}

}
