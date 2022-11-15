package com.mogotco.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.UserDTO;
import com.mogotco.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	String dir = "user/";
	
	@Autowired
	UserService user_service;
	
	public void maincenter(Model model) {
	}
	
	//로그인페이지
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center", dir+"login");
		return "main";
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(Model model, String id, String pwd, HttpSession session) {
		
		UserDTO user = null;
		
		try {
			user = user_service.get(id);
			if(user == null) {
				model.addAttribute("center", dir + "login");
			} else {
				if(pwd.equals(user.getUserpwd())) {
					session.setAttribute("loginuser", user);
					maincenter(model);
				} else {
					model.addAttribute("center", dir + "login");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "main";
	}
	
	@RequestMapping("/logintest")
	public String logintest(Model model) {
		model.addAttribute("center", "logintest");
		return "main";
	}
	
	//마이페에지
	@RequestMapping("/mypage")
	public String mypage(Model model) {
		model.addAttribute("center", dir+"mypage");
		return "main";
	}
	
	//회원가입페이지
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center", dir+"register");
		return "main";
	}
	
	//회원정보수정페이지
	@RequestMapping("/usermodify")
	public String usermodify(Model model) {
		model.addAttribute("center", dir+"usermodify");
		return "main";
	}

	
}
