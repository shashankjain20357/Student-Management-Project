package com.student.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.studentmanagementsystem.entities.Student;
import com.student.studentmanagementsystem.entities.StudentResponse;
import com.student.studentmanagementsystem.service.StudentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/students")

public class StudentController {

    @Autowired
    private StudentService studentService;
  
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{student_id}")
    public StudentResponse getStudentById(@PathVariable Long student_id) {
        return studentService.getStudentById(student_id);
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{student_id}")
    public void deleteStudent(@PathVariable Long student_id) {
        studentService.deleteStudent(student_id);
    }

    @GetMapping("/test")
    public String getMethodName() {
        
        return "hello";
    }

    @PutMapping("/{student_id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long student_id, @RequestBody Student updatedStudent) {
        Student updated = studentService.updateStudent(student_id, updatedStudent);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
