package com.jpa.controller;

import java.util.List;

import com.jpa.entities.Student;

public interface IStudentController {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Student getSuStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public Student updateStudent(Integer id, Student updateStudent);

}
