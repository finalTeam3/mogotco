package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
	
	@RequestMapping("/blog_single")
	public String blog_single(Model model) {
		model.addAttribute("center", "blog_single");
		return "index";
	}
	
}
