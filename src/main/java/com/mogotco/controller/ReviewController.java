package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	String review = "review/";
	
	//리뷰페이지
	@RequestMapping("/review")
	public String review(Model model) {
		model.addAttribute("center", review+"review");
		return "main";
	}
	
	
}
