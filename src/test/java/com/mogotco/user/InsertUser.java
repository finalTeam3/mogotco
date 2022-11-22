package com.mogotco.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.UserDTO;
import com.mogotco.service.UserService;

@SpringBootTest
class InsertUser {
	
	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		
		UserDTO user = new UserDTO("qkrajswl1541", "qkrajswl", "박먼지", "서울시 강북구 수유동 410-80, 201호", "010-1541-4009", "braddust@gmail.com", 
									null, 0, null, 0, null, null, null, "남", null, null, null, null, null, 0);
		try {
			service.register(user);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
