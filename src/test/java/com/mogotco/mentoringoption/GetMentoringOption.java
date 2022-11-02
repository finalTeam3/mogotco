package com.mogotco.mentoringoption;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.service.MentoringOptionService;

@SpringBootTest
	class GetMentoringOption {
	@Autowired
	MentoringOptionService service;
	
	@Test
	void contextLoads() {
		MentoringOptionDTO moption = null;
		try {
			moption = service.get(404);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(moption);
		
	}

}
