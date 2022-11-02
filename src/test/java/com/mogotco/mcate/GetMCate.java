package com.mogotco.mcate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MCateDTO;
import com.mogotco.service.MCateService;

@SpringBootTest
	class GetMCate {
	@Autowired
	MCateService service;
	
	@Test
	void contextLoads() {
		MCateDTO mcate = null;
		try {
			mcate = service.get(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(mcate);
		
	}

}
