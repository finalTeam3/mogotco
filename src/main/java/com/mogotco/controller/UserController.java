package com.mogotco.controller;

import java.util.HashMap;
import java.util.Random;

//import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogotco.dto.MentorDTO;
import com.mogotco.dto.UserDTO;
//import com.mogotco.service.KakaologinAPI;
import com.mogotco.service.MentorService;
import com.mogotco.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	String dir = "user/";
	
	@Autowired
	UserService user_service;
	
	//@Autowired
	//KakaologinAPI kakao_service;
	
	@Autowired
	MentorService mentor_service;
	
	//@Autowired
	//JavaMailSender mailSender;
	
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
		return "redirect:/";
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	//카카오 로그인
	@RequestMapping(value = "/kakaologin", method = RequestMethod.GET)
	public String kakaologin(@RequestParam(value = "code", required = false) String kakaocode, Model model, HttpSession session) throws Exception {
		model.addAttribute("center", dir + "kakaologin");
		System.out.println(kakaocode);
		//String accessToken = kakao_service.getAccessToken(kakaocode);
		//System.out.println("kakao access token : " + accessToken);
		
		//HashMap<String, Object> userInfo = kakao_service.getUserInfo(accessToken);
		//System.out.println("access Token : " + accessToken);
		//System.out.println("nickname : " + userInfo.get("profile_nickname"));
		//System.out.println("email : " + userInfo.get("account_email"));
		
		
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
	
	//회원가입기능
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, UserDTO user) {
		try {
			user_service.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	//이메일 인증번호 보내기
	@RequestMapping("/emailCheck")
	@ResponseBody
	public String emailCheck(String email) throws Exception {
		
		// 인증번호 생성 (맨 앞자리가 0이 아니길 원했음)
		Random r = new Random();
		int num = r.nextInt(888888) + 111111;
		
		// 메일 정보 세팅
		String setFrom = "mogotcomentoring@gmail.com";	// 보내는 이
		String toMail = email;	// 받는 이
		String title = "MOGOTCO 회원가입 이메일 인증번호 메일입니다."; 	// 메일 제목
		String content = "인증번호는 " + num + " 입니다. 인증번호를 입력 후 인증 버튼을 눌러주세요."; 	// 메일 내용
		
		// 단순 텍스트 메일 전송용
		//MimeMessage msg = mailSender.createMimeMessage();
		//MimeMessageHelper msgHelper = new MimeMessageHelper(msg, "UTF-8");
		
		// 메일 작성
		//msgHelper.setFrom("상부3조 <mogotcomentoring@gmail.com>");
		//msgHelper.setTo(toMail);
		//msgHelper.setSubject(title);
		//msgHelper.setText(content);
		
		// 메일 보내기
		//mailSender.send(msg);
		
		// ajax 이용시 데이터 타입은 string만 가능하기에 형 변환
		String confirmNum = Integer.toString(num);
		
		return confirmNum;
	}
	
}
