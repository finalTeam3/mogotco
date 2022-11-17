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
		//PurchaseDetailDTO detailmember = null;
		try {
			detail = purchasedetailservice.wholedetail(id);
			//detailmember = purchasedetailservice.groupcount(mentoringmembercnt);
			model.addAttribute("list", detail);
			//model.addAttribute("member", detailmember);
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
