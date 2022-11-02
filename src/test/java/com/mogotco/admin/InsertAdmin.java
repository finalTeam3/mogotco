package com.mogotco.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.AdminDTO;
import com.mogotco.dto.PurchaseDTO;
import com.mogotco.service.AdminService;

@SpringBootTest
class InsertAdmin {

	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		AdminDTO admin = new AdminDTO("admin05", "pwd05", "신관리");
		try {
			service.register(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

