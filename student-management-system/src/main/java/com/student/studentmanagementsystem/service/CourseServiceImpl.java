package com.student.studentmanagementsystem.service;

import com.student.studentmanagementsystem.entities.Course;
import com.student.studentmanagementsystem.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Course saveCourse(Course course) {
        // Add any validation or business logic before saving
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long courseId, Course updatedCourse) {
        Optional<Course> optionalExistingCourse = courseRepository.findById(courseId);

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
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
