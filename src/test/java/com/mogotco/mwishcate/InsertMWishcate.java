package com.mogotco.mwishcate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MWishcateDTO;
import com.mogotco.service.MWishcateService;

@SpringBootTest
class InsertMWishcate {

	@Autowired
	MWishcateService service;
	
	@Test
	void contextLoads() {
		MWishcateDTO mwishcate = new MWishcateDTO(0, 50, 104, null, null,null,null,null);
		try {
			service.register(mwishcate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

