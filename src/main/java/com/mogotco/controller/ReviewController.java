package com.mogotco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.MWishcateDTO;
import com.mogotco.dto.MentorDTO;
import com.mogotco.dto.ReviewDTO;
import com.mogotco.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	ReviewService review_service;
	
}
