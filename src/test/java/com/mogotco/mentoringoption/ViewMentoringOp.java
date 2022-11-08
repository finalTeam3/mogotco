package com.mogotco.mentoringoption;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.service.MentoringOptionService;

@SpringBootTest
	class ViewMentoringOp {
	@Autowired
	MentoringOptionService service;
	
	// 멘토링 옵션 시간과 재고를 동시에 출력 대비(화면출력 대비)
	@Test
	void contextLoads() {
		List<MentoringOptionDTO> moption = null;
		try {
			moption = service.viewMentoringOp(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(MentoringOptionDTO c:moption) {
			System.out.println(c);
		}
	}

}
