package com.mogotco.mentoring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.service.MentoringService;

@SpringBootTest
	class UpdateMentoring {
	@Autowired
	MentoringService service;
	
	String  day = "2022-11-30"; 
	java.sql.Date mdate = java.sql.Date.valueOf(day);
	
	@Test
	void contextLoads() {
		MentoringDTO mentoring = new MentoringDTO(204,103,30,70000,mdate,"f.jpg",null,1,null,"테스트","테스트3","이직관련상담",1,null,null,null,null,0,null,0);
		try {
			service.modify(mentoring);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
