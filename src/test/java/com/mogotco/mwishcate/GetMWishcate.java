package com.mogotco.mwishcate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MWishcateDTO;
import com.mogotco.service.MWishcateService;

@SpringBootTest
class GetMWishcate {

	@Autowired
	MWishcateService service;
	
	@Test
	void contextLoads() {
		MWishcateDTO mwishcate = null;
		try {
			mwishcate = service.get(1100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mwishcate);
	}

}
