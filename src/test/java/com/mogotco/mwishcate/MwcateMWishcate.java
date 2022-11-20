package com.mogotco.mwishcate;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MWishcateDTO;
import com.mogotco.service.MWishcateService;

@SpringBootTest
class MwcateMWishcate {

	@Autowired
	MWishcateService service;
	
	@Test
	void contextLoads() {
		List<MWishcateDTO> list = null;
		try {
			list = service.mwcate(103);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(MWishcateDTO c:list) {
			System.out.println(c);
		}
		
	}

}




