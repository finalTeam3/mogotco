package com.mogotco.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.BoardDTO;
import com.mogotco.service.BoardService;

@SpringBootTest
class InsertBoard {
	
	@Autowired
	BoardService service;
	
	@Test
	void contextLoads() {
		
		BoardDTO board = new BoardDTO(0, "admin01", null, "공지써야대는디", "머라쓰지", 2);
		try {
			service.register(board);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
