package com.mogotco.mentor;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentorDTO;
import com.mogotco.service.MentorService;

@SpringBootTest
class MentoritemMentor {

	@Autowired
	MentorService service;
	
	@Test
	void contextLoads() {
		MentorDTO list = null;
		try {
			list = service.mentoritem(101);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			System.out.println(list);
		
		
	}

}




