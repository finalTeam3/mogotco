package com.mogotco.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.MWishcateDTO;
import com.mogotco.dto.MentorDTO;
import com.mogotco.dto.UserDTO;
import com.mogotco.frame.Util;
import com.mogotco.service.MWishcateService;
import com.mogotco.service.MentorService;
import com.mogotco.service.MentoringService;
import com.mogotco.service.UserService;


@Controller
@RequestMapping("/mentor")
public class MentorController {
	
	String mentor = "mentor/";
	
	@Autowired
	MentorService mservice;

	@Autowired
	MentoringService mtiservice;
	
	@Autowired
	UserService uservice;
	
	@Autowired
	MWishcateService mwservice;

	@Value("${admindir}")
	String admindir;
	
	@Value("${userdir}")
	String userdir;
	
	//아이디값 유무 판단
	@RequestMapping("/idcheck")
	public void idcheck(int mentorid,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);	
		if(session == null) {
					try {
						response.sendRedirect("/mogotco/mentor/nonid?mentorid="+mentorid);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//controller주소로 감
				}else {
					try {
						response.sendRedirect("/mogotco/mentor/mentordetail?mentorid="+mentorid);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//controller주소로 감
				}
			}
	
	
	
	//멘토 상세페이지
	@RequestMapping("/mentordetail")
	public String mentordetail(Model model, int mentorid) {
		MentorDTO mta = null;
		MentorDTO mtd = null;
		List<MentorDTO> mtlist = null;
		List<MWishcateDTO> mwclist = null;
		try {
					mta = mservice.get(mentorid);
					mtd = mservice.mentordetail(mentorid);
					mtlist = mservice.mentoritem(mentorid);
					mwclist = mwservice.mwcate(mentorid);
					model.addAttribute("mta",mta);
					model.addAttribute("mtd",mtd);
					model.addAttribute("mtlist",mtlist);
					model.addAttribute("mwclist",mwclist);
					model.addAttribute("center", mentor+"mentordetail");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "main";
	}
	
	//비회원 멘토 상세 페이지
	@RequestMapping("/nonid")
	public String nonid(Model model, int mentorid) {
		MentorDTO mta = null;
		MentorDTO mtd = null;
		List<MentorDTO> mtlist = null;
		List<MWishcateDTO> mwclist = null;
		try {
				mta = mservice.get(mentorid);
				mtd = mservice.mentordetail(mentorid);
				mtlist = mservice.mentoritem(mentorid);
				mwclist = mwservice.mwcate(mentorid);
				model.addAttribute("mta",mta);
				model.addAttribute("mtd",mtd);
				model.addAttribute("mtlist",mtlist);
				model.addAttribute("mwclist",mwclist);
				model.addAttribute("center", mentor+"mentordetail1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "main";
	}
	
	//멘토 수정페이지
	@RequestMapping("/mentormodify")
	public String mentormodify(Model model, String id) {
		MentorDTO mentorall = null;
		try {
			mentorall = mservice.mentorAll(id);
			model.addAttribute("m",mentorall);
			model.addAttribute("center", mentor+"mentormodify");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}
	
	// 멘토 정보 업데이트 기능
	@RequestMapping("/modifyimpl")
	public String update(Model model, MentorDTO mentordto) {

		String mpimgname = mentordto.getMpimg().getOriginalFilename();
		mentordto.setMentorimg(mpimgname);
		
		String mcimgname = mentordto.getMcimg().getOriginalFilename();
		mentordto.setMcardimg(mcimgname);		
		
		try {
			Util.saveMentorFile(mentordto.getMpimg(), mentordto.getMcimg(), admindir, userdir);
			mservice.modify(mentordto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:mentormodify?id="+mentordto.getUserid();
	}	
	
	//멘토 등록페이지
	@RequestMapping("/mentorregister")
	public String mentorregister(Model model, String id) {
		UserDTO user = null;
		try {
			user = uservice.get(id);
			model.addAttribute("u", user);
			model.addAttribute("center", mentor+"mentorregister");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}

	// 멘토 정보 등록 기능 (멘토 지원)
	@RequestMapping("/registerimpl")
	public String register(Model model, MentorDTO mentordto) {
		
		String mpimgname = mentordto.getMpimg().getOriginalFilename();
		mentordto.setMentorimg(mpimgname);
		
		String mcimgname = mentordto.getMcimg().getOriginalFilename();
		mentordto.setMcardimg(mcimgname);
		
		try {
			Util.saveMentorFile(mentordto.getMpimg(), mentordto.getMcimg(), admindir, userdir);
			mservice.register(mentordto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:mentorregister?id="+mentordto.getUserid();
	}		
	
}
