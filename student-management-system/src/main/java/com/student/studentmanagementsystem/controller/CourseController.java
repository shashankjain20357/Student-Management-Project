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

import com.student.studentmanagementsystem.entities.Course;
import com.student.studentmanagementsystem.service.CourseService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{course_id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long course_id) {
        Course course = courseService.getCourseById(course_id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        Course savedCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(savedCourse);
    }

    @PutMapping("/{course_id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long course_id, @RequestBody Course updatedCourse) {
        Course updated = courseService.updateCourse(course_id, updatedCourse);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            // Handle not found scenario
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{course_id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long course_id) {
        courseService.deleteCourse(course_id);
        return ResponseEntity.noContent().build();
    }
}
