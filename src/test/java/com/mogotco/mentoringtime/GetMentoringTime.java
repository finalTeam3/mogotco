package com.mogotco.mentoringtime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringTimeDTO;
import com.mogotco.service.MentoringTimeService;

@SpringBootTest
	class GetMentoringTime {
	@Autowired
	MentoringTimeService service;
	
	@Test
	void contextLoads() {
		MentoringTimeDTO mtime = null;
		try {
			mtime = service.get(1214);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(mtime);
		
	}

}
