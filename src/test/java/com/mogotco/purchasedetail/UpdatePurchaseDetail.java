package com.mogotco.purchasedetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.service.PurchaseDetailService;

@SpringBootTest
class UpdatePurchaseDetail {

	@Autowired
	PurchaseDetailService service;
	
	@Test
	void contextLoads() {
		PurchaseDetailDTO purchase = new PurchaseDetailDTO(704, 201, 604,1);
		try {
			service.modify(purchase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

