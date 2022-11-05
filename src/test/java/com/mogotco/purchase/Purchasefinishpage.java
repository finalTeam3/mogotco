package com.mogotco.purchase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.PurchaseDTO;
import com.mogotco.service.PurchaseService;

@SpringBootTest
class Purchasefinishpage {

	@Autowired
	PurchaseService service;
	
	@Test
	void contextLoads() {
		PurchaseDTO purchase = null;
		try {
			purchase = service.purchasefinishpage(603);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(purchase);
	}

}
