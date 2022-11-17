package com.mogotco.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mogotco.dto.UserDTO;
import com.mogotco.service.KakaologinAPI;
import com.mogotco.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	String dir = "user/";
	
	@Autowired
	UserService user_service;
	
	@Autowired
	KakaologinAPI kakao_service;
	
	public void maincenter(Model model) {
	}
	
	//로그인페이지
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center", dir+"login");
		return "main";
	}
	
	//로그인기능
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
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "main";
	}
	
	//카카오 로그인
	@RequestMapping(value = "/kakaologin", method = RequestMethod.GET)
	public String kakaologin(@RequestParam(value = "code", required = false) String kakaocode, Model model, HttpSession session) throws Exception {
		model.addAttribute("center", dir + "kakaologin");
		System.out.println(kakaocode);
		String accessToken = kakao_service.getAccessToken(kakaocode);
		System.out.println("kakao access token : " + accessToken);
		
		HashMap<String, Object> userInfo = kakao_service.getUserInfo(accessToken);
		System.out.println("access Token : " + accessToken);
		System.out.println("nickname : " + userInfo.get("profile_nickname"));
		System.out.println("email : " + userInfo.get("account_email"));
		
		
//		  if(userInfo.get("account_email") != null) { 
//			  session.setAttribute("userId", userInfo.get("account_email")); 
//			  session.setAttribute("accessToken", accessToken); 
//			}
		 
		return "main";
	}
	
	//마이페이지
	@RequestMapping("/mypage")
	public String mypage(Model model, String userid) {
		UserDTO myuser = null;
		try {
			myuser = user_service.getMypage(userid);
			model.addAttribute("us", myuser);
			model.addAttribute("center", dir+"mypage");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	//회원가입페이지
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center", dir+"register");
		return "main";
	}
	
	//회원가입기능
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, UserDTO user) {
		System.out.println(user);
		try {
			user_service.register(user);
			model.addAttribute("center", dir+"login");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	//회원정보수정페이지
	@RequestMapping("/usermodify")
	public String usermodify(Model model) {
		model.addAttribute("center", dir+"usermodify");
		return "main";
	}

	
}
