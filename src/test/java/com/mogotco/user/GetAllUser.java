package com.mogotco.user;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.UserDTO;
import com.mogotco.service.UserService;

@SpringBootTest
class GetAllUser {
	
	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		
		List<UserDTO> list = null;
		try {
			list = service.get();
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(UserDTO u:list) {
			System.out.println(u);
		}
	}
	
}
