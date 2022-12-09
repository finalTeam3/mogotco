package com.mogotco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.MentorDTO;
import com.mogotco.dto.UserCouponDTO;
import com.mogotco.dto.UserDTO;
import com.mogotco.service.MentorService;
import com.mogotco.service.UserCouponService;
import com.mogotco.service.UserService;

@Controller
@RequestMapping("/coupon")
public class CouponController {
	
	@Autowired
	UserCouponService ucservice;
	
	@Autowired
	UserService uservice;
	
	@Autowired
	MentorService mservice;
	
	String coupon = "coupon/";
	
	@RequestMapping("/mycoupon")
	public String mycoupon(Model model, String id) {
		List<UserCouponDTO> cplist= null;
		UserDTO myuser = null;
		MentorDTO mentor =null;		
		try {
			myuser = uservice.get(id);
			mentor = mservice.mentorAll(id);
			cplist = ucservice.userCouponAll(id);
			
			model.addAttribute("userid", id);
			model.addAttribute("cp",cplist);
			model.addAttribute("us", myuser);
			model.addAttribute("ms", mentor);
//			System.out.println(cplist);
			model.addAttribute("center", coupon + "mycoupon");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}

}
