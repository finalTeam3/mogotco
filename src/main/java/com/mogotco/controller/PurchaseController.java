package com.mogotco.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.service.PurchaseDetailService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	String purchase = "purchase/";
	
	//service
	@Autowired
	PurchaseDetailService purchasedetailservice;
	
	//구매페이지
	@RequestMapping("")
	public String purchase(Model model, HttpSession session) {
		model.addAttribute("center", purchase+"purchase");
		return "main";
	}
	
	//구매상세페이지
	@RequestMapping("/purchasedetail")
	public String purchasedetail(Model model, String id) {
		List<PurchaseDetailDTO> detail = null;
		PurchaseDetailDTO detailmember = null;
		try {
			//멘토링 정보를 불러오고
			detail = purchasedetailservice.wholedetail(id);
			//향상 for문에 first라는 개별 객체에 넣어줌
			for(PurchaseDetailDTO first : detail) {
				//멘토링 멤버수를 뽑기위해 mentoringoptionid를 불러오고
				Integer mentoringoptionid = first.getMentoringoptionid();
				//뽑은 멤버수 정보를
				detailmember = purchasedetailservice.groupcount(mentoringoptionid);
				//다시 first객체에 setting해준다.
				first.setMentoringmembercnt(detailmember.getMentoringmembercnt());
			}
			model.addAttribute("list", detail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("center", purchase+"purchasedetail");
		return "main";
	}
	
	//구매완료페이지
	@RequestMapping("/purchasefinish")
	public String purchasefinish(Model model, HttpSession session) {
		model.addAttribute("center", purchase+"purchasefinish");
		return "main";
	}
	

	
}
