package com.mogotco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.MentorDTO;
import com.mogotco.service.MentorService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	MentorService mentor_service;
	
	String dir = "review/";
	
	//리뷰페이지
	@RequestMapping("/review")
	public String review(Model model, int mentorid) {
		MentorDTO mentor = null;
		try {
			mentor = mentor_service.get(mentorid);
			model.addAttribute("reviewmentor", mentor);
			model.addAttribute("center", "mentor/mentordetail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return "main";
	}
	
	
}
