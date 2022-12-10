package com.mogotco.controller;

import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.service.PurchaseDetailService;

@Controller
@RequestMapping
public class MailController {
	
	@Autowired
	PurchaseDetailService purchasedetail_service;
	
	@Autowired
	JavaMailSender mailSender;
	
	@RequestMapping("/emailalarm")
	@ResponseBody
	public String emailalarm(String email) throws Exception {
		
		List<PurchaseDetailDTO> purde = null;
		purde = purchasedetail_service.todaymentoringuser();
		System.out.println(purde);
		
		
		
//		// 메일 정보 세팅
//		String setFrom = "mogotcomentoring@gmail.com";	// 보내는 이
//		String toMail = email;	// 받는 이
//		String title = "MOGOTCO 멘토링 알림 테스트 메일"; 	// 메일 제목
//		String content = "내일 멘토링입니당"; 	// 메일 내용
//		
//		// 단순 텍스트 메일 전송용
//		MimeMessage msg = mailSender.createMimeMessage();
//		MimeMessageHelper msgHelper = new MimeMessageHelper(msg, "UTF-8");
//		
//		// 메일 작성
//		msgHelper.setFrom("상부3조 <mogotcomentoring@gmail.com>");
//		msgHelper.setTo(toMail);
//		msgHelper.setSubject(title);
//		msgHelper.setText(content);
//		
//		Date d = new Date();
//		System.out.println(d);
//		
//		// 메일 보내기
//		mailSender.send(msg);
		
		return "main";
	}
	
}
