package com.mogotco.purchasedetail;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.service.PurchaseDetailService;

@SpringBootTest
class TodayMentoringMail {

	@Autowired
	PurchaseDetailService service;
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	@Test
	void contextLoads() {
		
		List<String> list = null;
		
		try {
			list = service.todaymentoringmail();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < list.size(); i++) {
			
			String subject = "test 메일";
	        String content = "멘토링 6일 남으셨네요";
	        String from = "mogotcomentoring@gmail.com";
	        String to = list.get(i);
	        
	        MimeMessage mail = mailSender.createMimeMessage();
	        MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "UTF-8");
	        
	        try {
				mailHelper.setFrom(from);
				mailHelper.setTo(to);
				mailHelper.setSubject(subject);
				mailHelper.setText(content);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
	        System.out.println(mail);
			mailSender.send(mail);
		}
		
	}

}




