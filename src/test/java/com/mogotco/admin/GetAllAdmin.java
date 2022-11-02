package com.mogotco.admin;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.AdminDTO;
import com.mogotco.service.AdminService;

@SpringBootTest
class GetAllAdmin {

	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		List<AdminDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(AdminDTO c:list) {
			System.out.println(c);
		}
		
	}

}




