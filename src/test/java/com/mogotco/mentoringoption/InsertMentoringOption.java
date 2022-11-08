package com.mogotco.mentoringoption;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.service.MentoringOptionService;

@SpringBootTest
	class InsertMentoringOption {
	@Autowired
	MentoringOptionService service;
	
	// 멘토링 옵션에 시간과 재고를 배열의 크기로 insert(멘토의 시간 선택이 여러개이기 때문)

	@Test
	void contextLoads() {
		ArrayList<MentoringOptionDTO> list = new ArrayList<MentoringOptionDTO>();
		MentoringOptionDTO moption = new MentoringOptionDTO(0,204,"22:00",6);
		MentoringOptionDTO moption2 = new MentoringOptionDTO(0,205,"10:00",3);
		MentoringOptionDTO moption3 = new MentoringOptionDTO(0,206,"11:00",4);
		list.add(moption);
		list.add(moption2);
		list.add(moption3);

		

		
		
		try {
			for(int i=0; i<list.size(); i++) {
				MentoringOptionDTO str = list.get(i);
				service.register(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
