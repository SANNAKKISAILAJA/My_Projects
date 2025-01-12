package com.example.demostudent.service;

import com.example.demostudent.entity.Student;
import com.example.demostudent.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepository;

    public Student createStudent(Student student) {
        if (studentRepository.existsByStudentEmail(student.getStudentEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(long id) {
        return studentRepository.findById(id);
    }
}
