package com.mogotco.mentoringtime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringTimeDTO;
import com.mogotco.service.MentoringTimeService;

@SpringBootTest
	class GetAllIMentoringTime {
	@Autowired
	MentoringTimeService service;
	
	@Test
	void contextLoads() {
		List<MentoringTimeDTO> mtime = null;
		try {
			mtime = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(MentoringTimeDTO c:mtime) {
			System.out.println(c);
		}
	}

}
