package com.mogotco.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.UserDTO;
import com.mogotco.service.UserService;

@SpringBootTest
class UpdateUser {
	
	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		
		UserDTO user = new UserDTO("qkrajswl1541", "qkrgPwjd", "빵먼지", "혜정이네집", "010-4009-1542", "nomail@gmail.com", null, 0, "2019-07-15", 0, null, null, null, null);
		try {
			service.modify(user);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
