package com.mogotco.purchasedetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.service.PurchaseDetailService;

@SpringBootTest
class InsertPurchaseDetail {

	@Autowired
	PurchaseDetailService service;
	
	@Test
	void contextLoads() {
		//id는 자동증가이므로 초기화값인 아무것들만 넣어주면됨
		PurchaseDetailDTO purchase = new PurchaseDetailDTO(0, 202, 403,0,0, null, 0, null, null, null, null, null, null, null, 0,0) ;
		try {
			service.register(purchase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

