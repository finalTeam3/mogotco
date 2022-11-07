package com.mogotco.mentoring;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.service.MentoringService;

@SpringBootTest
	class SelectMentoringAll {
	@Autowired
	MentoringService service;
	
	@Test
	void contextLoads() {
		List<MentoringDTO> mlist = null;
		try {
			mlist = service.selectMentoringAll(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(MentoringDTO c:mlist) {
			System.out.println(c);
		}
	}

}
