package com.mogotco.mentoringtime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringTimeDTO;
import com.mogotco.service.MentoringTimeService;

@SpringBootTest
	class InsertMentoringTime {
	@Autowired
	MentoringTimeService service;
	

	@Test
	void contextLoads() {

		MentoringTimeDTO mtime = new MentoringTimeDTO(0,204,"23:00");
		try {
			service.register(mtime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
