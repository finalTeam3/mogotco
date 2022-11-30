package com.mogotco.review;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.ReviewDTO;
import com.mogotco.service.ReviewService;

@SpringBootTest
class Mentorwish {
	
	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
		List<ReviewDTO> review = null;
		try {
			review = service.mentorwish(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(ReviewDTO r:review) {
			System.out.println(r);
		}
		
	}
	
}
