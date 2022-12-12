package com.mogotco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.BoardDTO;
import com.mogotco.dto.MCateDTO;
import com.mogotco.dto.MentoringDTO;
import com.mogotco.dto.ReviewDTO;
import com.mogotco.service.BoardService;
import com.mogotco.service.MCateService;
import com.mogotco.service.MentoringService;
import com.mogotco.service.ReviewService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	BoardService board_service;
	
	//mentoring
	@Autowired
	MentoringService mentoring_service;
	
	//review
	@Autowired
	ReviewService review_service;
	
	@Autowired
	MCateService mcateservice;
	
	@RequestMapping("")
	public String main(Model model) {
		List<MentoringDTO> immedmentoring = null;
		List<ReviewDTO> topmentor = null;
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		//처음 mentoring 뿌려줄 때
		try {
			//지금 즉시 받을 수 있는 가장 빠른 멘토링
			immedmentoring = mentoring_service.mentoringimmed();
			//평점이 가장 높은 순서대로 멘토 4명
			topmentor = review_service.topmentors();
			
			model.addAttribute("imme", immedmentoring);
			model.addAttribute("topm", topmentor);
			
			// cate 검색
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			
			model.addAttribute("center", "maincenter");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}
	
	//about
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("center", "about");
		return "main";
	}
}
