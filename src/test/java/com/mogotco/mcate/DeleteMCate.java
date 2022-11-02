package com.mogotco.mcate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.MCateService;

@SpringBootTest
	class DeleteMCate {
	
	@Autowired
	MCateService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(90);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
