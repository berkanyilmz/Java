package com.springdersleri.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springdersleri.model.Employee;

@Configuration
public class AppConfig {

	@Bean
	public List<Employee> employeeList() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1", "Berkan", "Yılmaz"));
		employeeList.add(new Employee("2", "Ahmet", "Ercan"));
		employeeList.add(new Employee("3", "Mehmet", "Tuluk"));
		employeeList.add(new Employee("4", "Ayşe", "Sever"));
		employeeList.add(new Employee("5", "Fatma", "Yagci"));
		employeeList.add(new Employee("6", "Hayriye", "Aydın"));
		employeeList.add(new Employee("7", "Seda", "Birol"));
		employeeList.add(new Employee("8", "Berkan", "Şaş"));
		employeeList.add(new Employee("9", "Seda", "Saymaz"));
		employeeList.add(new Employee("10", "Yasin", "Yagci"));
		
		return employeeList;
		
	}
	
}
