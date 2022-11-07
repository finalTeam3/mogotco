package com.mogotco.mentoringoption;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.service.MentoringOptionService;

@SpringBootTest
	class ViewMentoringTime {
	@Autowired
	MentoringOptionService service;
	
	@Test
	void contextLoads() {
		List<MentoringOptionDTO> moption = null;
		try {
			moption = service.viewMentorigTime(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(MentoringOptionDTO c:moption) {
			System.out.println(c);
		}
	}

}
