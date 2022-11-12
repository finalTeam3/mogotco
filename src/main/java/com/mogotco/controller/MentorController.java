package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MentorController {
	
	String mentor = "mentor/";
	
	//멘토상세페이지
	@RequestMapping("/mentordetail")
	public String mentordetail(Model model) {
		model.addAttribute("center", mentor+"mentordetail");
		return "main";
	}
	
	//멘토수정페이지
	@RequestMapping("/mentormodify")
	public String mentormodify(Model model) {
		model.addAttribute("center", mentor+"mentormodify");
		return "main";
	}
	
	//멘토 등록페이지
	@RequestMapping("/mentorregister")
	public String mentorregister(Model model) {
		model.addAttribute("center", mentor+"mentorregister");
		return "main";
	}

	
}
