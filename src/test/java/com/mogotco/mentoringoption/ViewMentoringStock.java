package com.mogotco.mentoringoption;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.service.MentoringOptionService;

@SpringBootTest
	class ViewMentoringStock {
	@Autowired
	MentoringOptionService service;
	
	// 멘토링 옵션 재고만 따로 출력대비(일단 group by형태로 출력하지만 추후 변경할 수 도)
	@Test
	void contextLoads() {
		List<MentoringOptionDTO> moption = null;
		try {
			moption = service.viewMentoringStock(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(MentoringOptionDTO c:moption) {
			System.out.println(c);
		}
	}

}
