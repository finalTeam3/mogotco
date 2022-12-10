package com.mogotco;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Scheduled(cron = "0 0 14 * * *")
	public void alarmring() {
		
		Date d = new Date();
		
		System.out.println(d);
		
		
	}
	
}
