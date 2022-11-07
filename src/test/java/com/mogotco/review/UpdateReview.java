package com.mogotco.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.ReviewDTO;
import com.mogotco.service.ReviewService;

@SpringBootTest
class UpdateReview {
	
	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
		ReviewDTO review = new ReviewDTO(504, 200, "qkrgPwjd1541", 5, "너무 좋았습니다.", null,null);
		try {
			service.modify(review);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
