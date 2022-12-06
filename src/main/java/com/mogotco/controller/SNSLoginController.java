package com.mogotco.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.UserDTO;
import com.mogotco.service.GithubloginAPI;
import com.mogotco.service.KakaologinAPI;
import com.mogotco.service.UserService;

@Controller
@RequestMapping("/user")
public class SNSLoginController {

	String dir = "user/";
	
	@Autowired
	UserService user_service;
	
	@Autowired
	KakaologinAPI kakao_service;
	
	@Autowired
	GithubloginAPI github_service;
	
	//카카오 로그인
	@RequestMapping("/kakaologin")
	public Object kakaologin(Model model, String code, HttpSession session) throws Exception {
		model.addAttribute("center", dir+"kakaologin");
//		System.out.println("code inga controller = " + code);
		
		String accessToken = kakao_service.getAccessToken(code);
//		System.out.println("code accesstoken controller = " + accessToken);
		
		Map<String, Object> userInfo = kakao_service.getUserInfo(accessToken);
//		System.out.println("code userInfo controller = " + userInfo);
		
		String userid = (String) userInfo.get("id");
		String userbirth = (String) userInfo.get("birthday");
		String usergen = (String) userInfo.get("gender");
		String useremail = (String) userInfo.get("email");
		String username = (String) userInfo.get("nickname");
		String profile_image = (String) userInfo.get("profile_image");
		
		UserDTO user = null;
		user = user_service.get(userid);
		
		if (user == null) {
			UserDTO newuser = new UserDTO(userid, null, username, null, null, useremail, null, 0, null, 0, null, null, null, null, null, null, null, null, null, 0);
			user_service.register(newuser);
			session.setAttribute("loginuser", newuser);
		} else {
			session.setAttribute("loginuser", user);
		}
		
		return "redirect:/";
	}
	
	// 깃허브 로그인 
	@RequestMapping("/githublogin")
	public String githublogin(Model model, String code, HttpSession session) throws Exception {
		model.addAttribute("center", dir+"githublogin");
//		System.out.println("code inga controller = " + code);
		
		String accessToken = github_service.getAccessToken(code);
//		System.out.println("code accesstoken controller = " + accessToken);
		
		Map<String, Object> userInfo = github_service.getUserInfo(accessToken);
//		System.out.println("code userInfo controller = " + userInfo);
		
		String userid = (String) userInfo.get("id");
		String snsgit = (String) userInfo.get("git");
		
		UserDTO user = null;
		user = user_service.get(userid);
		
		if (user == null) {
			UserDTO newuser = new UserDTO(userid, null, null, null, null, null, null, 0, null, 0, null, null, null, null, null, null, null, null, snsgit, 0);
			user_service.register(newuser);
			session.setAttribute("loginuser", newuser);
		} else {
			session.setAttribute("loginuser", user);
		}
		
		return "redirect:/";
	}
}
