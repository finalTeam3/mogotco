package com.mogotco.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.UserDTO;
import com.mogotco.service.UserService;

@SpringBootTest
class GetUser {
	
	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		
		UserDTO user = null;
		try {
			user = service.get("whdlsdud4321");
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(user);
		
	}
	
}
