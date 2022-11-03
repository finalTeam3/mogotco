package com.mogotco.mentoringoption;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.service.MentoringOptionService;

@SpringBootTest
	class InsertMentoringOption {
	@Autowired
	MentoringOptionService service;
	

	@Test
	void contextLoads() {

		MentoringOptionDTO moption = new MentoringOptionDTO(0,0,7);
		try {
			service.register(moption);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
