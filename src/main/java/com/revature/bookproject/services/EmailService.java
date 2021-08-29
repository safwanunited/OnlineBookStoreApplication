package com.revature.bookproject.services;

import org.springframework.mail.SimpleMailMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public static SimpleMailMessage sendEmail(String sendTo,String subject,String message) {
		
		SimpleMailMessage sms =new SimpleMailMessage();
		sms.setFrom("companyblue100@gmail.com");
		sms.setTo(sendTo);
		sms.setSubject(subject);
		sms.setText(message);
		
		return sms;	
	}
}
