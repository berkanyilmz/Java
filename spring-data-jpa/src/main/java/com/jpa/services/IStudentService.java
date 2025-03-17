package com.jpa.services;

import java.util.List;

import com.jpa.entities.Student;

public interface IStudentService {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public Student getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public Student updateStudent(Integer id, Student updatedStudent);

}
