package com.jpa.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entities.Student;
import com.jpa.repository.StudentRepository;
import com.jpa.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void deleteStudent(Integer id) {
		Student dbStudent = getStudentById(id);
		
		if (dbStudent != null) {
			studentRepository.delete(dbStudent);
		}
		
	}

	@Override
	public Student updateStudent(Integer id, Student updatedStudent) {
		Student dbStudent = getStudentById(id);
		if (dbStudent != null ) {
			dbStudent.setFirstName(updatedStudent.getFirstName());
			dbStudent.setLastName(updatedStudent.getLastName());
			dbStudent.setBirtOfDate(updatedStudent.getBirtOfDate());
			
			return studentRepository.save(dbStudent);
		}
		return null;
	}

}
