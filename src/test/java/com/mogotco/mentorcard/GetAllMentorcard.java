package com.mogotco.mentorcard;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentorDTO;
import com.mogotco.dto.MentorcardDTO;
import com.mogotco.service.MentorcardService;

@SpringBootTest
class GetAllMentorcard {

	@Autowired
	MentorcardService service;
	
	@Test
	void contextLoads() {
		List<MentorcardDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(MentorcardDTO c:list) {
			System.out.println(c);
		}
		
	}

}




