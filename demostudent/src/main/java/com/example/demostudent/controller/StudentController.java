package com.example.demostudent.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demostudent.entity.Student;
import com.example.demostudent.repo.StudentRepo;

import jakarta.validation.Valid;

@RestController
@Validated
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    /**
     * Create a new student
     * 
     * @param student - the student entity to save
     * @return ResponseEntity with created student and HTTP status 201
     */
    @PostMapping("/api/students")
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
        if (studentRepo.existsByStudentEmail(student.getStudentEmail())) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT); // Conflict if email already exists
        }
        return new ResponseEntity<>(studentRepo.save(student), HttpStatus.CREATED);
    }

    /**
     * Get all students
     * 
     * @return ResponseEntity with list of all students and HTTP status 200
     */
    @GetMapping("/api/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /**
     * Get a student by ID
     * 
     * @param id - the ID of the student to retrieve
     * @return ResponseEntity with student or 404 if not found
     */
    @GetMapping("/api/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Optional<Student> student = studentRepo.findById(id);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update an existing student by ID
     * 
     * @param id   - the ID of the student to update
     * @param stud - updated student data
     * @return ResponseEntity with updated student or 404 if not found
     */
    @PutMapping("/api/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @Valid @RequestBody Student stud) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            Student existingStudent = student.get();
            existingStudent.setStudentName(stud.getStudentName());
            existingStudent.setStudentAge(stud.getStudentAge());
            existingStudent.setStudentEmail(stud.getStudentEmail());
            existingStudent.setStudentCourse(stud.getStudentCourse());
            return new ResponseEntity<>(studentRepo.save(existingStudent), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a student by ID
     * 
     * @param id - the ID of the student to delete
     * @return ResponseEntity with HTTP status 204 or 404 if not found
     */
    @DeleteMapping("/api/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            studentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
