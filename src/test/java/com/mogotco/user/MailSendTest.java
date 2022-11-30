package com.mogotco.user;

//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
class MailSendTest {
	
	//@Autowired
	//JavaMailSenderImpl mailSender;
	
	// 객체를 직접 생성해서 메일 보내기 테스트
	@Test
	void contextLoads() {
		
		String subject = "test 메일";
        String content = "메일 테스트 내용";
        String from = "mogotcomentoring@gmail.com";
        String to = "skbsy153@gmail.com";
        
        //MimeMessage mail = mailSender.createMimeMessage();
        //MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "UTF-8");
        
        //try {
			//mailHelper.setFrom(from);
			//mailHelper.setTo(to);
			//mailHelper.setSubject(subject);
			//mailHelper.setText(content);
			
			//mailSender.send(mail);
		//} catch (//MessagingException e) {
			//e.printStackTrace();
		//}
        
	}
	
}
