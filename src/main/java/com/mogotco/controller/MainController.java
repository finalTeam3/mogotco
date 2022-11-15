package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping("")
	public String main() {
		return "main";
	}
	
	//자주 묻는 질문 페이지
	@RequestMapping("/faq")
	public String faq(Model model) {
		model.addAttribute("center", "faq");
		return "main";
	}
	
	//공지사항
	@RequestMapping("/notice")
	public String blog(Model model) {
		model.addAttribute("center", "notice");
		return "main";
	}
	
}
