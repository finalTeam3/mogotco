package com.mogotco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WishlistController {
	
	String wishlist = "wishlist/";
	
	//wishlist페이지
	@RequestMapping("/wishlist")
	public String wishlist(Model model) {
		model.addAttribute("center", wishlist+"wishlist");
		return "main";
	}
	
	
}
