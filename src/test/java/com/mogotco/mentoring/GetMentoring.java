package com.mogotco.mentoring;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.service.MentoringService;

@SpringBootTest
	class GetMentoring {
	@Autowired
	MentoringService service;
	
	@Test
	void contextLoads() {
		MentoringDTO mentoring = null;
		try {
			mentoring = service.get(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(mentoring);
		
	}

}
