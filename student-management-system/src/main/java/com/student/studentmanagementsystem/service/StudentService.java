package com.student.studentmanagementsystem.service;

import java.util.List;

import com.student.studentmanagementsystem.entities.Student;
import com.student.studentmanagementsystem.entities.StudentResponse;

public interface StudentService {
    List<Student> getAllStudents();
    StudentResponse getStudentById(Long student_id);
    Student saveStudent(Student student);
    Student updateStudent(Long student_id, Student updatedStudent);
    void deleteStudent(Long student_id);
}
