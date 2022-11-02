package com.mogotco.purchasedetail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.service.PurchaseDetailService;

@SpringBootTest
class GetAllPurchaseDetail {

	@Autowired
	PurchaseDetailService service;
	
	@Test
	void contextLoads() {
		List<PurchaseDetailDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(PurchaseDetailDTO c:list) {
			System.out.println(c);
		}
		
	}

}




