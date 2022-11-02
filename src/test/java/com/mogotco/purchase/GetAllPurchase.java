package com.mogotco.purchase;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.PurchaseDTO;
import com.mogotco.service.PurchaseService;

@SpringBootTest
class GetAllPurchase {

	@Autowired
	PurchaseService service;
	
	@Test
	void contextLoads() {
		List<PurchaseDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(PurchaseDTO c:list) {
			System.out.println(c);
		}
		
	}

}




