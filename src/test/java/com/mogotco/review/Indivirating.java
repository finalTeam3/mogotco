package com.mogotco.review;

import java.util.List;

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
			list = service.indivirating(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
			System.out.println(list);
		
	}
	
}
