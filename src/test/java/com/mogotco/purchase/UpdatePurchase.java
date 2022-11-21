package com.mogotco.purchase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.PurchaseDTO;
import com.mogotco.service.PurchaseService;

@SpringBootTest
class UpdatePurchase {

	@Autowired
	PurchaseService service;
	
	@Test
	void contextLoads() {
		PurchaseDTO purchase = new PurchaseDTO(604, "qkrtjdgns1234", 20000, null, "카카오페이", "신한카드", 0, null, null, null, null, null, 0,0,0,0); 
		try {
			service.modify(purchase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

