package com.mogotco.mentoring;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.service.MentoringService;

@SpringBootTest
	class ViewMentoringOp {
	@Autowired
	MentoringService service;
	
	// 멘토링 옵션 인서트된 옵션들을 화면에 출력
	@Test
	void contextLoads() {
		MentoringDTO mto = null;
		try {
			mto = service.viewMentoringOp(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
			System.out.println(mto);
		}
	}


