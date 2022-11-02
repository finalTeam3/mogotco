package com.mogotco.purchase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.PurchaseService;

@SpringBootTest
class DeletePurchase {

	@Autowired
	PurchaseService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(604);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}