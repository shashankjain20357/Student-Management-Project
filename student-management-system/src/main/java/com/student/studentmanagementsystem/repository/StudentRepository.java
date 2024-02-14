package com.student.studentmanagementsystem.repository;

import com.student.studentmanagementsystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Add any custom queries if needed
}
