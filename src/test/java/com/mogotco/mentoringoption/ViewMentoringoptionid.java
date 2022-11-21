package com.mogotco.mentoringoption;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.service.MentoringOptionService;

@SpringBootTest
	class ViewMentoringoptionid {
	@Autowired
	MentoringOptionService service;
	//(choyunyoung add)
	//멘토링과 멘토링 시간에 따른 멘토링옵션id출력(mentoringdetail->purchase)
	@Test
	void contextLoads() {
		MentoringOptionDTO moption = null;
		try {
			moption = service.viewmentoringoptionid(200,"11:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(moption);
		
	}

}
