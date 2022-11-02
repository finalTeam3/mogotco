package com.mogotco.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.BoardService;

@SpringBootTest
class DeleteBoard {
	
	@Autowired
	BoardService service;
	
	@Test
	void contextLoads() {
		
		try {
			service.remove(804);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
