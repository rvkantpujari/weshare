package com.weshare.utility;

import java.util.Locale;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.weshare.model.User;

@Component
public class MailConstructor {

	public SimpleMailMessage constructResetTokenEmail(
			String contextPath, Locale locale, String token, User user)
	{
		
		String message1 = "Please click on this link to verify your account.\n";
		String url = contextPath + "/confirmRegistration?token="+token;
		String message2="\n\nRegards, \nWeShare Team.";
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("WeShare - Account Verification");
		email.setText(message1+url+message2);
		email.setFrom("helpcare.weshare@gmail.com");
		return email;
	}
	
}