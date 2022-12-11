package com.mogotco;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mogotco.service.PurchaseDetailService;

@Component
public class Scheduler {
	
	@Autowired
	PurchaseDetailService purchasedetail_service;
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	@Scheduled(cron = "1 0 0 * * *")
	public void todayalarm() {
		
		List<String> list = null;
		try {
			list = purchasedetail_service.todaymentoringmail();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < list.size(); i++) {
			
			String subject = "멘토링 알림 메일입니다.";
	        String content = "오늘 멘토링이 예정되어 있습니다! 늦지 않게 참석해주세요!";
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
			
			mailSender.send(mail);
		}
		
	}
	
	@Scheduled(cron = "1 30 6 * * *")
	public void tomorrowalarm() {
		
		List<String> list = null;
		try {
			list = purchasedetail_service.tomorrowmentoringmail();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < list.size(); i++) {
			
			String subject = "멘토링 알림 메일입니다.";
	        String content = "내일 멘토링입니다! 필요한 자료를 미리 준비해주세요!";
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
			
			mailSender.send(mail);
		}
		
		
	}
	
}
