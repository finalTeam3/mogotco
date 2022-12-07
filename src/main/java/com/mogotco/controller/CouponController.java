package com.mogotco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.UserCouponDTO;
import com.mogotco.service.UserCouponService;

@Controller
@RequestMapping("/coupon")
public class CouponController {
	
	@Autowired
	UserCouponService ucservice;
	
	String coupon = "coupon/";
	
	@RequestMapping("/mycoupon")
	public String mycoupon(Model model, String id) {
		List<UserCouponDTO> cplist= null;
		
		try {
			cplist = ucservice.userCouponAll(id);
			model.addAttribute("userid", id);
			model.addAttribute("cp",cplist);
			System.out.println(cplist);
			model.addAttribute("center", coupon + "mycoupon");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}

}
