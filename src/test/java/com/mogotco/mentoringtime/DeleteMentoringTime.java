package com.mogotco.mentoringtime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.MentoringTimeService;

@SpringBootTest
	class DeleteMentoringTime {
	
	@Autowired
	MentoringTimeService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(1214);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
