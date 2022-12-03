package com.mogotco.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.ReviewDTO;
import com.mogotco.service.ReviewService;

@SpringBootTest
class InsertReview {
	
	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
		ReviewDTO review = new ReviewDTO(0, 200, "qkrgPwjd1541", 1, "넘조아써",null, 0,null,0,null,null,null, null,null,0,0);
		try {
			service.register(review);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
