package com.student.studentmanagementsystem.service;

import com.student.studentmanagementsystem.entities.Student;
import com.student.studentmanagementsystem.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student saveStudent(Student student) {
        student.setEnrolments(null);
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long studentId, Student updatedStudent) {
        Optional<Student> optionalExistingStudent = studentRepository.findById(studentId);

        if (optionalExistingStudent.isPresent()) {
            Student existingStudent = optionalExistingStudent.get();
            // Update only non-null fields
            if (updatedStudent.getName() != null) {
                existingStudent.setName(updatedStudent.getName());
            }

            if (updatedStudent.getEmail() != null) {
                existingStudent.setEmail(updatedStudent.getEmail());
            }

            if (updatedStudent.getContactNo() != null) {
                existingStudent.setContactNo(updatedStudent.getContactNo());
            }

            if (updatedStudent.getAddress() != null) {
                existingStudent.setAddress(updatedStudent.getAddress());
            }

            if (updatedStudent.getCourseEnrolled() != null) {
                existingStudent.setCourseEnrolled(updatedStudent.getCourseEnrolled());
            }

            // Save the updated student
            return studentRepository.save(existingStudent);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
