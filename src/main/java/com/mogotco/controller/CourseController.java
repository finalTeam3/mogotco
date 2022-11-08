package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	String dir = "courses/";
	
	@RequestMapping("")
	public String course(Model model) {
		model.addAttribute("center", "courses");
		return "index";
	}
	
	@RequestMapping("/course")
	public String courses(Model model) {
		model.addAttribute("center", "course");
		return "index";
	}
	
}
