package com.student.studentmanagementsystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.studentmanagementsystem.entities.Course;
import com.student.studentmanagementsystem.entities.Enrolment;
import com.student.studentmanagementsystem.entities.Student;
import com.student.studentmanagementsystem.entities.StudentResponse;
import com.student.studentmanagementsystem.repository.CourseRepository;
import com.student.studentmanagementsystem.repository.StudentRepository;
import com.student.studentmanagementsystem.service.EnrolmentService;
import com.student.studentmanagementsystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrolmentService enrolmentService;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentResponse getStudentById(Long student_id) {
        Optional<Student> student =  studentRepository.findById(student_id);
        StudentResponse s = updateEnroledCourseDetails(student.get());
        return  s;
    }

    StudentResponse updateEnroledCourseDetails(Student student){
        StudentResponse s = new StudentResponse();
        List<Enrolment> enrolments = enrolmentService.enrolmentByStudentId(student.getId());
        System.out.println(enrolments.size());
        List<Course> courseDetails = new ArrayList();
        for(Enrolment e: enrolments){
            System.out.println("course:: "+e.getCourse_id()+ "student:: "+e.getStudent_id());
            Course c = courseRepository.findById(e.getCourse_id()).get();
            courseDetails.add(c);
            
        }
        s.setId(student.getId());
        s.setAddress(student.getAddress());
        s.setContactNo(student.getContactNo());
        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setCourseEnrolled(courseDetails);
        return s;
    }

    @Override
    public Student saveStudent(Student student) {
        // student.setEnrolments(null);
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long student_id, Student updatedStudent) {
        Optional<Student> optionalExistingStudent = studentRepository.findById(student_id);

        if (optionalExistingStudent.isPresent()) {
            Student existingStudent = optionalExistingStudent.get();

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

            // if (updatedStudent.getCourseEnrolled() != null) {
            //     existingStudent.setCourseEnrolled(updatedStudent.getCourseEnrolled());
            // }

            return studentRepository.save(existingStudent);
        } else {
            return null;
        }
    }

    @Override
    public void deleteStudent(Long student_id) {
        studentRepository.deleteById(student_id);
    }

    
}
