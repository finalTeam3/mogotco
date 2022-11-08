package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {
	
	@RequestMapping("/course")
	public String courses(Model model) {
		model.addAttribute("center", "course");
		return "index";
	}
	
}
