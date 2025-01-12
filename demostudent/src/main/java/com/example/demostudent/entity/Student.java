package com.example.demostudent.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name ="student", uniqueConstraints = {@UniqueConstraint(columnNames ="studentEmail")})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Nonnull
    @Min(value = 1, message = "Age must be a positive integer")
    @Column(nullable = false)
    private int studentAge;

    @Nonnull
    @NotBlank(message = "Name cannot be blank")
    @Column(nullable = false)
    private String studentName;

    @Nonnull
    @NotBlank(message = "Course cannot be blank")
    @Column(nullable = false)
    private String studentCourse;

    @Nonnull
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    @Column(unique = true, nullable = false)
    private String studentEmail;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(long id, int studentAge, String studentName, String studentCourse, String studentEmail) {
        this.id = id;
        this.studentAge = studentAge;
        this.studentName = studentName;
        this.studentCourse = studentCourse;
        this.studentEmail = studentEmail;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    // toString method
    @Override
    public String toString() {
        return "Student [id=" + id + ", studentAge=" + studentAge + ", studentName=" + studentName + ", studentCourse="
                + studentCourse + ", studentEmail=" + studentEmail + "]";
    }
}
