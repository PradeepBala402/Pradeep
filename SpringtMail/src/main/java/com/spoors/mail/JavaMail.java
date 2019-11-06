package com.spoors.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class JavaMail {
	private MailSender sender;

	public void setSender(MailSender sender) {
		this.sender = sender;
	}
	public void setSendMail(String from,String to,String subject,String message) {
		SimpleMailMessage smm=new SimpleMailMessage();
		smm.setFrom(from);
		smm.setTo(to);
		smm.setSubject(subject);
		smm.setText(message);
		sender.send(smm);
	}

}
