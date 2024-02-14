package com.student.studentmanagementsystem.controller;

import org.springframework.web.bind.annotation.*;

import com.student.studentmanagementsystem.entities.Course;
import com.student.studentmanagementsystem.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")

public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public Optional<Course> getCourseById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @PostMapping
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
    }
}
