package com.mogotco.mentoring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.MentoringService;

@SpringBootTest
	class DeleteMentoring {
	
	@Autowired
	MentoringService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(204);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
