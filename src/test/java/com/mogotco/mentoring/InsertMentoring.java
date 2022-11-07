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

		MentoringDTO mentoring = new MentoringDTO(0,103,30,20000,mdate,"f.jpg",null,1,null,"7안길","테스트3","이직관련상담",1,null,null,null);
		try {
			service.register(mentoring);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




}
