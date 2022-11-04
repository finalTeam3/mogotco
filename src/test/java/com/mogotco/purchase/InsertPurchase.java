package com.mogotco.purchase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.PurchaseDTO;
import com.mogotco.service.PurchaseService;

@SpringBootTest
class InsertPurchase {

	@Autowired
	PurchaseService service;
	
	@Test
	void contextLoads() {
		//id는 자동증가이므로 초기화값인 아무것들만 넣어주면됨
		PurchaseDTO purchase = new PurchaseDTO(0, "qkrtjdgns1234", 20000, null, "네이버페이", 0, null, null, null, null, 0);
		try {
			service.register(purchase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

