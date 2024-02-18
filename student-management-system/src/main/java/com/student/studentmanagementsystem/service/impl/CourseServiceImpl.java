package com.student.studentmanagementsystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.studentmanagementsystem.entities.Course;
import com.student.studentmanagementsystem.entities.Enrolment;
import com.student.studentmanagementsystem.entities.Student;
import com.student.studentmanagementsystem.repository.CourseRepository;
import com.student.studentmanagementsystem.repository.StudentRepository;
import com.student.studentmanagementsystem.service.CourseService;
import com.student.studentmanagementsystem.service.EnrolmentService;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private EnrolmentService enrolmentService;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long course_id) {
        Optional<Course> course = courseRepository.findById(course_id);
        //updateEnroledCourseDetails
        return updateEnroledStudentDetails(course.get());
    }
    Course updateEnroledStudentDetails(Course course){
        List<Enrolment> enrolments = enrolmentService.enrolmentByCourseId(course.getCourseId());
        List<Student> students = new ArrayList();
        for(Enrolment e: enrolments){
            Student s = studentRepository.findById(e.getStudent_id()).get();
            students.add(s);
        }
        course.setStudents(students);
        return course;
    }

    @Override
    public Course saveCourse(Course course) {
        // Add any validation or business logic before saving
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long course_id, Course updatedCourse) {
        Optional<Course> optionalExistingCourse = courseRepository.findById(course_id);

        if (optionalExistingCourse.isPresent()) {
            Course existingCourse = optionalExistingCourse.get();
            // Update fields of existingCourse with values from updatedCourse
            existingCourse.setCourseName(updatedCourse.getCourseName());
            existingCourse.setDuration(updatedCourse.getDuration());
            // Save the updated course
            return courseRepository.save(existingCourse);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    @Override
    public void deleteCourse(Long course_id) {
        courseRepository.deleteById(course_id);
    }
}
