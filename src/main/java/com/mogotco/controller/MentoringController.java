package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MentoringController {
	
	String mentoring = "mentoring/";
	
	//멘토링목록
	@RequestMapping("/mentoring")
	public String mentoring(Model model) {
		model.addAttribute("center", mentoring+"mentoring");
		return "main";
	}
	
	//멘토링상세페이지
	@RequestMapping("/mentoringdetail")
	public String mentoringdetail(Model model) {
		model.addAttribute("center", mentoring+"mentoringdetail");
		return "main";
	}
	
	//멘토링 등록페이지
	@RequestMapping("/mentoringregister")
	public String mentoringregister(Model model) {
		model.addAttribute("center", mentoring+"mentoringregister");
		return "main";
	}

	//mservice page
	@RequestMapping("/mservice")
	public String mservice() {
		return mentoring+"mservice";
	}
	
}
