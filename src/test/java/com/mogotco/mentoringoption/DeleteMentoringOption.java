package com.mogotco.mentoringoption;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.MentoringOptionService;

@SpringBootTest
	class DeleteMentoringOption {
	
	@Autowired
	MentoringOptionService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(404);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
