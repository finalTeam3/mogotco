package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PshController {
	
	@RequestMapping("/chatbot")
	public String chatbot(Model model) {
		model.addAttribute("center", "chatbot");
		return "index";
	}
	
}
