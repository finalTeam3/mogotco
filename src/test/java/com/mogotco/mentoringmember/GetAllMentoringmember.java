package com.mogotco.mentoringmember;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringmemberDTO;
import com.mogotco.service.MentoringmemberService;

@SpringBootTest
class GetAllMentoringmember {

	@Autowired
	MentoringmemberService service;
	
	@Test
	void contextLoads() {
		List<MentoringmemberDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(MentoringmemberDTO c:list) {
			System.out.println(c);
		}
		
	}

}




