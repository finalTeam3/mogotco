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
		PurchaseDetailDTO purchase = new PurchaseDetailDTO(704, 408, 604,0,0, null, 0, null, null, null, null, null, null, null, 0,0);
		try {
			service.modify(purchase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

