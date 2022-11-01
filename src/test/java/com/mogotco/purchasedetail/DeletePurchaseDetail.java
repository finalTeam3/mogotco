package com.mogotco.purchasedetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.PurchaseDetailService;

@SpringBootTest
class DeletePurchaseDetail {

	@Autowired
	PurchaseDetailService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(704);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}