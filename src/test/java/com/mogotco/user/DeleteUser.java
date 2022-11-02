package com.mogotco.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.UserService;

@SpringBootTest
class DeleteUser {
	
	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		
		try {
			service.remove("qkrajswl1541");
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
