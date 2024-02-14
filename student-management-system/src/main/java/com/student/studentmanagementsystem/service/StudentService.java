package com.student.studentmanagementsystem.service;

import com.student.studentmanagementsystem.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long studentId);
    Student saveStudent(Student student);
    Student updateStudent(Long studentId, Student updatedStudent);
    void deleteStudent(Long studentId);
}
