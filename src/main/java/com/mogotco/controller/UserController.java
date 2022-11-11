package com.mogotco.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.UserDTO;
import com.mogotco.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService user_service;
	
	@RequestMapping("/logintest")
	public String logintest(Model model) {
		model.addAttribute("center", "logintest");
		return "index";
	}
	
	public void maincenter(Model model) {
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(Model model, String id, String pwd, HttpSession session) {
		
		UserDTO user = null;
		
		try {
			user = user_service.get(id);
			if(user == null) {
				model.addAttribute("center", "login");
			} else {
				if(pwd.equals(user.getUserpwd())) {
					session.setAttribute("loginuser", user);
					maincenter(model);
				} else {
					model.addAttribute("center", "login");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
}
