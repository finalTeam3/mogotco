package com.mogotco.mentorcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentorcardDTO;
import com.mogotco.service.MentorcardService;

@SpringBootTest
class UpdateMentorcard {

	@Autowired
	MentorcardService service;
	
	@Test
	void contextLoads() {
		MentorcardDTO mentorcard = new MentorcardDTO(1004, 105, "F회사", "user06", "사원");
		try {
			service.modify(mentorcard);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

