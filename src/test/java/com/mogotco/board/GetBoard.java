package com.mogotco.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.BoardDTO;
import com.mogotco.service.BoardService;

@SpringBootTest
class GetBoard {
	
	@Autowired
	BoardService service;
	
	@Test
	void contextLoads() {
		
		BoardDTO board = null;
		try {
			board = service.get(804);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(board);
		
	}
	
}
