package com.mogotco.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.AdminService;

@SpringBootTest
class DeleteAdmin {

	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove("admin05");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}