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
		
		// 테스트 페이지
//		model.addAttribute("center", dir+"kakaologin");
//		System.out.println("code inga controller = " + code);
		
		// 받아온 인가코드를 다시 보내 엑세스 토큰을 받아옴
		String accessToken = kakao_service.getAccessToken(code);
//		System.out.println("code accesstoken controller = " + accessToken);
		
		// 엑세스 토큰을 이용해 유저의 정보를 얻어옴
		Map<String, Object> userInfo = kakao_service.getUserInfo(accessToken);
//		System.out.println("code userInfo controller = " + userInfo);
		
		// 추출된 유저정보를 string으로 형 변환
		String kakaoid = (String) userInfo.get("id");
		String userbirth = (String) userInfo.get("birthday");
		String usergen = (String) userInfo.get("gender");
		String userid = (String) userInfo.get("email");
		String username = (String) userInfo.get("nickname");
		String profile_image = (String) userInfo.get("profile_image");
		
		// userid(카카오 이메일) 조회 후 null 값이면 새로운 user로 회원가입
		UserDTO user = null;
		user = user_service.get(userid);
		
		if (user == null) {
			UserDTO newuser = new UserDTO(userid, null, username, null, null, null, null, 0, null, 0, null, kakaoid, null, null, null, null, null, null, null,null, 0);
			user_service.register(newuser);
			session.setAttribute("loginuser", newuser);
		} else {
			session.setAttribute("loginuser", user);
		}
		
		return "redirect:mypage?userid="+user.getUserid();
	}
	
	// 깃허브 로그인 
	@RequestMapping("/githublogin")
	public String githublogin(Model model, String code, HttpSession session) throws Exception {
		
		// 테스트 페이지
//		model.addAttribute("center", dir+"githublogin");
//		System.out.println("code inga controller = " + code);
		
		// 받아온 인가코드를 다시 보내 엑세스 토큰을 받아옴
		String accessToken = github_service.getAccessToken(code);
//		System.out.println("code accesstoken controller = " + accessToken);
		
		// 엑세스 토큰을 이용해 유저의 정보를 얻어옴
		Map<String, Object> userInfo = github_service.getUserInfo(accessToken);
//		System.out.println("code userInfo controller = " + userInfo);
		
		// 추출된 유저정보를 string으로 형 변환
		String naverid = (String) userInfo.get("id");
		String userid = (String) userInfo.get("login");
		String snsgit = (String) userInfo.get("git");
		
		// userid(github 닉네임) 조회 후 null 값이면 새로운 user로 회원가입
		UserDTO user = null;
		user = user_service.get(userid);
		
		if (user == null) {
			UserDTO newuser = new UserDTO(userid, null, null, null, null, null, null, 0, null, 0, naverid, null, null, null, null, null, null, null, snsgit,null, 0);
			user_service.register(newuser);
			session.setAttribute("loginuser", newuser);
		} else {
			session.setAttribute("loginuser", user);
		}
		
		return "redirect:mypage?userid="+user.getUserid();
	}
}
