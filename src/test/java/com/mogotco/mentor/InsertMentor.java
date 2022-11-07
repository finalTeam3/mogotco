package com.mogotco.mentor;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentorDTO;
import com.mogotco.service.MentorService;

@SpringBootTest
class InsertMentor {

	@Autowired
	MentorService service;
	
	@Test
	void contextLoads() {
		MentorDTO mentor = new MentorDTO(0, "user05", "admin05", "E회사", "user05 멘토입니다", "profile05.jpg", "mcard05.jpg", 0, null, 0, "현) E회사 e개발팀 Backend Developer", null, null, null);
		try {
			service.register(mentor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

