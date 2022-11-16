package com.mogotco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.MentorDTO;
import com.mogotco.service.MentorService;

@Controller
@RequestMapping("/mentor")
public class MentorController {
	
	String mentor = "mentor/";
	
	@Autowired
	MentorService service;
	
	//멘토 상세페이지
	@RequestMapping("/mentordetail")
	public String mentordetail(Model model) {
		model.addAttribute("center", mentor+"mentordetail");
		return "main";
	}
	
	//멘토 수정페이지
	@RequestMapping("/mentormodify")
	public String mentormodify(Model model, String id) {
		MentorDTO mentorall = null;
		try {
			mentorall = service.mentorAll("qkrtjdgns1234");
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
		try {
			System.out.println(mentordto);
			service.modify(mentordto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:mentormodify?id="+mentordto.getUserid();
	}	
	
	//멘토 등록페이지
	@RequestMapping("/mentorregister")
	public String mentorregister(Model model) {
		model.addAttribute("center", mentor+"mentorregister");
		return "main";
	}

	
}
