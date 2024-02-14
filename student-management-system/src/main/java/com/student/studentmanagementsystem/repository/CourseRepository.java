package com.student.studentmanagementsystem.repository;

import com.student.studentmanagementsystem.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository <Course, Long> {
    
}
