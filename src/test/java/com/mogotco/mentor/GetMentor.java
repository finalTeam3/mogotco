package com.mogotco.mentor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentorDTO;
import com.mogotco.service.MentorService;

@SpringBootTest
class GetMentor {

	@Autowired
	MentorService service;
	
	@Test
	void contextLoads() {
		MentorDTO mentor = null;
		try {
			mentor = service.get(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mentor);
	}

}
