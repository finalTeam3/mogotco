package com.mogotco.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.AdminDTO;
import com.mogotco.service.AdminService;

@SpringBootTest
class GetAdmin {

	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		AdminDTO admin = null;
		try {
			admin = service.get("admin01");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(admin);
	}

}
