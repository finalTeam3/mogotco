package com.mogotco.mentoring;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.service.MentoringService;

@SpringBootTest
	class viewMentoringAll {
	@Autowired
	MentoringService service;
	
	@Test
	void contextLoads() {
		List<MentoringDTO> metoring = null;
		try {
			metoring = service.viewMentoringAll(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(MentoringDTO c:metoring) {
			System.out.println(c);
		}
	}

}
