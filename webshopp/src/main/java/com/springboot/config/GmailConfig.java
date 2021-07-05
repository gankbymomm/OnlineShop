package com.springboot.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.springboot.constant.SystemConstant;

@Configuration
public class GmailConfig {

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl impl = new JavaMailSenderImpl();
		impl.setDefaultEncoding("utf-8");
		impl.setHost("smtp.gmail.com");
		impl.setPort(587);
		impl.setUsername(SystemConstant.Email);
		impl.setPassword(SystemConstant.Password);
		Properties properties = impl.getJavaMailProperties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.debug", "true");
		return impl;
	}
}
