package com.springboot.service.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.springboot.bean.MailInfo;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailer;

	public void send(MailInfo info) throws MessagingException {
		MimeMessage message = mailer.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		helper.setFrom(info.getFrom());
		helper.setTo(info.getTo());
		helper.setSubject(info.getSubject());
		helper.setText(info.getBody(), true);
		helper.setReplyTo(info.getFrom());
		if (info.getCc() != null) {
			helper.setCc(info.getCc());
		}
		if (info.getBcc() != null) {
			helper.setBcc(info.getBcc());
		}
		if (info.getFiles() != null) {
			String[] paths = info.getFiles().split(",");
			for (String path : paths) {
				File file = new File(path);
				helper.addAttachment(file.getName(), file);
			}
			
		}
		mailer.send(message);
	}
}
