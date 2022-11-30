package com.mogotco.mentoring;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.mapper.MentoringMapper;
import com.mogotco.service.MentoringService;

@SpringBootTest
	class Mcatesearch {
	@Autowired
	MentoringMapper mapper;
	
	@Test
	void contextLoads() {
		List<MentoringDTO> metoring = null;
		try {
			metoring = mapper.mcatesearch("웹","테");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(MentoringDTO c:metoring) {
			System.out.println(c);
		}
	}

}
