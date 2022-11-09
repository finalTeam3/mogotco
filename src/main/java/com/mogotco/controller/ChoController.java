package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChoController {
	
	@RequestMapping("/order")
	public String order() {
		return "order";
	}
	
	@RequestMapping("/kg")
	public String kg() {
		return "kg";
	}
	
}
