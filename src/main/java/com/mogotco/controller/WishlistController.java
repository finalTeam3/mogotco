package com.mogotco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.WishlistDTO;
import com.mogotco.service.WishlistService;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {
	
	String wishlist = "wishlist/";
	
	@Autowired
	WishlistService wservice;
	
	//wishlist페이지
	@RequestMapping("/wishlist")
	public String wishlist(Model model, String id) {
		List<WishlistDTO> wlist = null;
		try {
			wlist = wservice.wmentor(id);
			model.addAttribute("wlist",wlist);
			model.addAttribute("center", wishlist+"wishlist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "main";
	}
	
	
}
