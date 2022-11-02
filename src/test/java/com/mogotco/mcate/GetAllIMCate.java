package com.mogotco.mcate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MCateDTO;
import com.mogotco.service.MCateService;

@SpringBootTest
	class GetAllIMCate {
	@Autowired
	MCateService service;
	
	@Test
	void contextLoads() {
		List<MCateDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(MCateDTO c:list) {
			System.out.println(c);
		}
	}

}
