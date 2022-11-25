package com.mogotco.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mogotco.dto.UserDTO;
import com.mogotco.dto.WishlistDTO;
import com.mogotco.frame.Util;
import com.mogotco.service.MentoringOptionService;
import com.mogotco.service.MentoringService;
import com.mogotco.service.MentoringmemberService;
import com.mogotco.service.OcrService;
import com.mogotco.service.PurchaseDetailService;
import com.mogotco.service.PurchaseService;
import com.mogotco.service.UserService;
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
	
	@Autowired
	UserService user_service;
	
	@Autowired
	OcrService ocrservice;
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${userdir}")
	String userdir;

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
		WishlistDTO wdt = null;
		try {
			wdt = wishservice.wishcheck(wish.getUserid(), wish.getMentorid());
			if(wdt == null) {
				wishservice.register(wish);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	
	//회원가입시 아이디 중복체크 기능
	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		String result = "";
		UserDTO user = null;
		try {
			user = user_service.get(cid);
			if(user != null) {
				result = "f";
			} else {
				result = "t";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/ocrresult")
	public Object ocrresult(MultipartHttpServletRequest filelist) {
		Object obj = null;
		String fieldName = "";
		MultipartFile mfile = null;
		
		Iterator<String> iter = filelist.getFileNames();
		while (iter.hasNext()) {
			fieldName = (String) iter.next();
			mfile = filelist.getFile(fieldName);
			System.out.println(mfile);
			Util.saveMcFile(mfile, admindir, userdir);
		}
		obj = ocrservice.ocrresult(mfile.getOriginalFilename());
		System.out.println(obj);
		return obj;
	}
	
	
}