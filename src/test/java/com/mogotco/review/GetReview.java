package com.mogotco.review;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.ReviewDTO;
import com.mogotco.service.ReviewService;

@SpringBootTest
class GetReview {
	
	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
		ReviewDTO review = null;
		try {
			review = service.get(504);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(review);
		
	}
	
}
