package com.student.studentmanagementsystem.repository;

import com.student.studentmanagementsystem.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Add any custom queries if needed
}
