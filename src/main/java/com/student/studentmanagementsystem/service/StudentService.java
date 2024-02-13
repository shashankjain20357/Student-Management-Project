package com.student.studentmanagementsystem.service;

import org.springframework.stereotype.Service;

import com.student.studentmanagementsystem.entities.Student;
import com.student.studentmanagementsystem.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public Student saveStudent(Student student) {
        student.setEnrolments(null);
        return studentRepository.save(student);
    }

    @SuppressWarnings("null")
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
