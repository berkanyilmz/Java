package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
