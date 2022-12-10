package com.mogotco.purchasedetail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.service.PurchaseDetailService;

@SpringBootTest
class TodayMentoringUser {

	@Autowired
	PurchaseDetailService service;
	
	@Test
	void contextLoads() {
		
		List<PurchaseDetailDTO> list = null;
		
		try {
			list = service.todaymentoringuser();
			System.out.println("list : " + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(PurchaseDetailDTO p:list) {
			System.out.println(p);
		}
		
	}

}




