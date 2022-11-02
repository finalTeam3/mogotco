package com.mogotco.mcate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MCateDTO;
import com.mogotco.service.MCateService;

@SpringBootTest
	class UpdateMCate {
	@Autowired
	MCateService service;
	
	@Test
	void contextLoads() {
		MCateDTO mcate = new MCateDTO(90,"테스트입니다.");
		try {
			service.modify(mcate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
