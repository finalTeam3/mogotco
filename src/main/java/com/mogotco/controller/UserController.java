package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	String user = "user/";
	
	//로그인페이지
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center", user+"login");
		return "main";
	}
	
	//마이페에지
	@RequestMapping("/mypage")
	public String mypage(Model model) {
		model.addAttribute("center", user+"mypage");
		return "main";
	}
	
	//회원가입페이지
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center", user+"register");
		return "main";
	}
	
	//회원정보수정페이지
	@RequestMapping("/usermodify")
	public String usermodify(Model model) {
		model.addAttribute("center", user+"usermodify");
		return "main";
	}
	

	
}
