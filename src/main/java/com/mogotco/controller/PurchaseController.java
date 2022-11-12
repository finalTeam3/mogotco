package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PurchaseController {
	
	String purchase = "purchase/";
	
	//구매페이지
	@RequestMapping("/purchase")
	public String purchase(Model model) {
		model.addAttribute("center", purchase+"purchase");
		return "main";
	}
	
	//구매상세페이지
	@RequestMapping("/purchasedetail")
	public String purchasedetail(Model model) {
		model.addAttribute("center", purchase+"purchasedetail");
		return "main";
	}
	
	//구매완료페이지
	@RequestMapping("/purchasefinish")
	public String purchasefinish(Model model) {
		model.addAttribute("center", purchase+"purchasefinish");
		return "main";
	}
	

	
}
