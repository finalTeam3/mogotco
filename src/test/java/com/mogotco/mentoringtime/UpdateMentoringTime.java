package com.mogotco.mentoringtime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringTimeDTO;
import com.mogotco.service.MentoringTimeService;

@SpringBootTest
	class UpdateMentoringTime {
	@Autowired
	MentoringTimeService service;
	
	@Test
	void contextLoads() {
		MentoringTimeDTO mtime = new MentoringTimeDTO(1214,205,"09:00");
		try {
			service.modify(mtime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
