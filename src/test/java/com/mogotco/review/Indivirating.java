package com.mogotco.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.ReviewDTO;
import com.mogotco.service.ReviewService;

@SpringBootTest
class Indivirating {
	
	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
		ReviewDTO list = null;
		try {
			list = service.indivirating("qkrgPwjd1541");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
