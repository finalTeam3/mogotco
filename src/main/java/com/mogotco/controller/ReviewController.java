package com.mogotco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.MentorDTO;
import com.mogotco.dto.ReviewDTO;
import com.mogotco.service.MentorService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	MentorService mentor_service;
	
	//리뷰페이지(멘토상세페이지 리뷰 탭)
	@RequestMapping("/review")
	public String review(Model model, int mentorid) {
		MentorDTO mentor = null;
		List<ReviewDTO> rlist = null;
		try {
			mentor = mentor_service.get(mentorid);
			model.addAttribute("reviewmentor", mentor);
			model.addAttribute("center", "mentor/mentordetail");
		} catch (Exception e) {
		}
		return "main";
	}
	
	
}
