package com.spring.main;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.AppConfig;
import com.spring.model.User;
import com.spring.services.LoginService;
import com.spring.services.UserService;

public class MainClass {

	public static void main(String[] args) {		
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		
		for (User user : userService.getUserList()) {
			System.out.println(user.getFirstName());
		}
		
		LoginService loginService = new LoginService();
		loginService.login();
	}
}
