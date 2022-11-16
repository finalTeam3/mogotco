package com.mogotco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.service.MentoringService;

@Controller
public class MentoringController {
	
	@Autowired
	MentoringService mservice;
	
	String mentoring = "mentoring/";
	
	//멘토링목록
	@RequestMapping("/mentoring")
	public String mentoring(Model model) {
		List<MentoringDTO> mlist = null; // 모든 멘토링 아이템용
		try {
			mlist = mservice.viewMentoringAll();
			model.addAttribute("mtr", mlist);
			model.addAttribute("center", mentoring+"mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return "main";
	}
	
	//멘토링상세페이지
	@RequestMapping("/mentoringdetail")
	public String mentoringdetail(Model model, int mentoringid) {
		MentoringDTO mto = null;
		try {
			mto = mservice.viewMentoringOp(mentoringid);
			model.addAttribute("mto", mto);
			model.addAttribute("center", mentoring+"mentoringdetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	//멘토링 등록페이지
	@RequestMapping("/mentoringregister")
	public String mentoringregister(Model model) {
		model.addAttribute("center", mentoring+"mentoringregister");
		return "main";
	}

	//mservice page
	@RequestMapping("/mservice")
	public String mservice() {
		return mentoring+"mservice";
	}
	
}
