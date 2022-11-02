package com.mogotco.mentor;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.MentorService;

@SpringBootTest
class DeleteMentor {

	@Autowired
	MentorService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(104);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}