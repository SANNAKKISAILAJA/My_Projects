package com.example.demostudent.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demostudent.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {
	boolean existsByStudentEmail(String studentEmail);
}
