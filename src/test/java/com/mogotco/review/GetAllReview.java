package com.mogotco.review;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.ReviewDTO;
import com.mogotco.service.ReviewService;

@SpringBootTest
class GetAllReview {
	
	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
		List<ReviewDTO> list = null;
		try {
			list = service.get();
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(ReviewDTO r:list) {
			System.out.println(r);
		}
	}
	
}
