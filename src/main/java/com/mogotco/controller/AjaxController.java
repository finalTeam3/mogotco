package com.mogotco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mogotco.dto.WishlistDTO;
import com.mogotco.service.MentoringOptionService;
import com.mogotco.service.MentoringService;
import com.mogotco.service.MentoringmemberService;
import com.mogotco.service.PurchaseDetailService;
import com.mogotco.service.PurchaseService;
import com.mogotco.service.WishlistService;


@RestController
public class AjaxController {
	
	@Autowired
	PurchaseService service;
	
	@Autowired
	PurchaseDetailService service1;
	
	@Autowired
	MentoringService service2;
	
	@Autowired
	MentoringmemberService service3;
	
	@Autowired
	MentoringOptionService service4;

	@Autowired
	WishlistService wishservice;

	@RequestMapping("/importsuccess")
	public Object importsuccess() {
		return "";
	}
	
	//userpoint(data저장이 안될 때)
	@RequestMapping("/pointcount")
	public Object pointcount(Integer total_price,Integer writepoint) {
		Integer modiprice =0;
		modiprice=total_price-writepoint;
		return modiprice;
	}
	
	// mentor를 wishlist 테이블에 추가
	@RequestMapping("/addwishlist")
	public Object addwishlist(WishlistDTO wish) {
		try {
			wishservice.register(wish);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
}