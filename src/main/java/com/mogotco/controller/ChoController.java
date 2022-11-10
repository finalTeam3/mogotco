package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChoController {
	
	String order = "order/";
	
	@RequestMapping("/order")
	public String order(Model model) {
		model.addAttribute("center", order+"order");
		return "index";
	}
	
	@RequestMapping("/main")
	public String main() {
		
		return "main";
	}
	
}
