package com.mogotco.mentor;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentorDTO;
import com.mogotco.service.MentorService;

@SpringBootTest
class UpdateMentor {

	@Autowired
	MentorService service;
	
	@Test
	void contextLoads() {
		MentorDTO mentor = new MentorDTO(104, "user06", "admin06", "F회사", "user06 멘토입니다", "profile06.jpg", "mcard06.jpg", 1, null, 2, "경력 업데이트", null, null, null, null, null, null,null,null,null,null,0,0,0,null,0);
		try {
			service.modify(mentor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

