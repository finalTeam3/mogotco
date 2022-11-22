package com.mogotco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.MCateDTO;
import com.mogotco.dto.MentoringDTO;
import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.service.MCateService;
import com.mogotco.service.MentoringOptionService;
import com.mogotco.service.MentoringService;

@Controller
@RequestMapping("/mentoring")
public class MentoringController {
	
	@Autowired
	MentoringService mservice;
	
	@Autowired
	MentoringOptionService moservice;
	
	@Autowired
	MCateService mcateservice;
	
	String mentoring = "mentoring/";
	
	//멘토링목록
	@RequestMapping("/mentoring")
	public String mentoring(Model model) {
		List<MentoringDTO> mlist = null; // 모든 멘토링 아이템용
		List<MCateDTO> catelist = null; // 카테고리 리스트용
		try {
			mlist = mservice.viewMentoringAll(); // 모든 멘토링 정보 넣어주기
			catelist = mcateservice.get(); // 모든 카테고리 리스트 정보 넣어주기
			model.addAttribute("mtr", mlist); // 등록된 멘토링 리스트
			model.addAttribute("mtcatelist", catelist); // 카테고리 리스트
			model.addAttribute("center", mentoring+"mentoring");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return "main";
	}
	
	//멘토링상세페이지
	@RequestMapping("/mentoringdetail")
	public String mentoringdetail(Model model, int mentoringid) {
		MentoringDTO mto = null; // 멘토링 옵션용
		MentoringDTO mtg = null; // 멘토 프로필 정보용
		List<MentoringOptionDTO> mttime = null; // 멘토링별 시간 리스트용
		try {
			mto = mservice.viewMentoringOp(mentoringid); // 멘토링 옵션 정보 넣어주기
			mtg = mservice.get(mentoringid); // 멘토 프로필 정보 넣어주기
			mttime = moservice.viewMentorigTime(mentoringid); // 멘토링 시간 리스트 넣어주기
			model.addAttribute("mto", mto);
			model.addAttribute("mttime", mttime);
			model.addAttribute("mtg", mtg);
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
