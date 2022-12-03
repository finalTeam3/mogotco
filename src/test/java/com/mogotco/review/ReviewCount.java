package com.mogotco.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.ReviewDTO;
import com.mogotco.service.ReviewService;

@SpringBootTest
class ReviewCount {
	
	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
		ReviewDTO review = null;
		
		try {
			review = service.reviewcnt(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(review);
		
	}
	
}
