package com.mogotco.purchasedetail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.service.PurchaseDetailService;

@SpringBootTest
class Remotedetail {

	@Autowired
	PurchaseDetailService service;
	
	@Test
	void contextLoads() {
		List<PurchaseDetailDTO> list = null;
		try {
			list = service.remotedetail("rlaaudgml4321");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
	}

}
