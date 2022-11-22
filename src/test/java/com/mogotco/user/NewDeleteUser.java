package com.mogotco.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.UserDTO;
import com.mogotco.service.UserService;

@SpringBootTest
class NewDeleteUser {
	
	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		
		UserDTO user = new UserDTO("qkrgPwjd1541", "qkrgPwjd", "박혜정", "서울 강북구 인수봉로61길 18", "010-4009-1541", "skbsy153@gmail.com", null, 0, "1994-11-08", 3000, null, null, null, "여", "01022", "201호", "(수유동, 참하우스토리)", 0);
		try {
			service.deleteuser(user);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
