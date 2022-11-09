package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChoController {
	
	@RequestMapping("/order")
	public String order(Model model) {
		model.addAttribute("center", "order");
		return "index";
	}
	
	@RequestMapping("/kg")
	public String kg() {
		return "kg";
	}
	
}
