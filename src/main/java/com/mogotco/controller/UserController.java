package com.mogotco.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mogotco.dto.MentorDTO;
import com.mogotco.dto.UserDTO;
import com.mogotco.service.KakaologinAPI;
import com.mogotco.service.MentorService;
import com.mogotco.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	String dir = "user/";
	
	@Autowired
	UserService user_service;
	
	@Autowired
	KakaologinAPI kakao_service;
	
	@Autowired
	MentorService mentor_service;
	
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
				model.addAttribute("logresult", "f");
				model.addAttribute("center", dir + "login");
			} else {
				if(pwd.equals(user.getUserpwd())) {
					model.addAttribute("logresult", "t");
					session.setAttribute("loginuser", user);
				} else {
					model.addAttribute("logresult", "f");
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
		MentorDTO mentor =null;
		try {
			myuser = user_service.get(userid);
			mentor = mentor_service.mentorAll(userid);
			model.addAttribute("us", myuser);
			model.addAttribute("ms", mentor);
			model.addAttribute("center", dir+"mypage");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	//마이페이지 수정 기능
	@RequestMapping("/mypageupdate")
	public String mypageupdate(UserDTO user) {
		try {
			user_service.modify(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:mypage?userid="+user.getUserid();
	}
	
	//회원 탈퇴 기능
	@RequestMapping("/deleteuser")
	public String deleteuser(UserDTO user, HttpSession session) {
		try {
			user_service.deleteuser(user);
			if(session != null) {
				session.invalidate();
			}
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
	
	//회원가입시 아이디 중복체크 기능
	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		String result = "";
		UserDTO user = null;
		try {
			user = user_service.get(cid);
			System.out.println(user);
			if(user != null) {
				result = "f";
			} else {
				result = "t";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
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
	
}
