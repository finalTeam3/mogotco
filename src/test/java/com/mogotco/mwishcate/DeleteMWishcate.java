package com.mogotco.mwishcate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.MWishcateService;

@SpringBootTest
class DeleteMWishcate {

	@Autowired
	MWishcateService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(1108);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}