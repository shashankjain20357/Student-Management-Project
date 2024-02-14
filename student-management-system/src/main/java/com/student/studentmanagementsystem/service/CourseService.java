package com.student.studentmanagementsystem.service;

import com.student.studentmanagementsystem.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long courseId);
    Course saveCourse(Course course);
    Course updateCourse(Long courseId, Course updatedCourse);
    void deleteCourse(Long courseId);
}
