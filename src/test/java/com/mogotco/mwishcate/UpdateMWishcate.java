package com.mogotco.mwishcate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MWishcateDTO;
import com.mogotco.dto.WishlistDTO;
import com.mogotco.service.MWishcateService;

@SpringBootTest
class UpdateMWishcate {

	@Autowired
	MWishcateService service;
	
	@Test
	void contextLoads() {
		MWishcateDTO mwishcate = new MWishcateDTO(1108, 70, 102, null, null);
		try {
			service.modify(mwishcate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

