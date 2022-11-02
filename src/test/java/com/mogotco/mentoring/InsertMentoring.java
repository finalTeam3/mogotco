package com.mogotco.mentoring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.service.MentoringService;

@SpringBootTest
	class InsertMentoring {
	@Autowired
	MentoringService service;
	
	String  day = "2022-11-20"; 
	java.sql.Date mdate = java.sql.Date.valueOf(day);
	
	@Test
	void contextLoads() {

		MentoringDTO mentoring = new MentoringDTO(0,101,10,11110,mdate,"d.jpg",null,1,null,"2안길","테스트3");
		try {
			service.register(mentoring);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




}
