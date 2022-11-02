package com.mogotco.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.BoardDTO;
import com.mogotco.service.BoardService;

@SpringBootTest
class UpdateBoard {
	
	@Autowired
	BoardService service;
	
	@Test
	void contextLoads() {
		
		BoardDTO board = new BoardDTO(804, null, null, "오프라인 멘토링 중단 안내", "코로나19로 잠시 오프라인 멘토링을 중단합니다", 1);
		try {
			service.modify(board);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
