package com.spring.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.model.User;
import com.spring.services.UserService;

@Configuration
public class AppConfig {
	
	@Bean
	public UserService userService() {
		UserService userService = new UserService();
		List<User> userList = new ArrayList<>();
		
		userList.add(new User("Berkan"));
		userList.add(new User("Sinan"));
		userList.add(new User("Ayşe"));
		
		userService.setUserList(userList);
		
		return userService;
	}

}
