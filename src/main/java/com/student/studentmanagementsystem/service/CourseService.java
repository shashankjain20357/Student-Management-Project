package com.student.studentmanagementsystem.service;

import org.springframework.stereotype.Service;

import com.student.studentmanagementsystem.entities.Course;
import com.student.studentmanagementsystem.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public Course saveCourse(Course course) {
        course.setStudents(null);
        course.setEnrolments(null);
        return courseRepository.save(course);
    }

    @SuppressWarnings("null")
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
