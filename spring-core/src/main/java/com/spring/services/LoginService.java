package com.spring.services;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.AppConfig;

public class LoginService {
	public void login() {
		// User listesine ihtiyacım var.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
	}
}
