package com.mogotco.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.BoardDTO;
import com.mogotco.service.BoardService;

@SpringBootTest
class GetAllBoard {
	
	@Autowired
	BoardService service;
	
	@Test
	void contextLoads() {
		
		List<BoardDTO> list = null;
		try {
			list = service.get();
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(BoardDTO b:list) {
			System.out.println(b);
		}
	}
	
}
