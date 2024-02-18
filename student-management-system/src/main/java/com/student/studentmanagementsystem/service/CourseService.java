package com.student.studentmanagementsystem.service;

import java.util.List;

import com.student.studentmanagementsystem.entities.Course;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long course_id);
    Course saveCourse(Course course);
    Course updateCourse(Long course_id, Course updatedCourse);
    void deleteCourse(Long course_id);
}
