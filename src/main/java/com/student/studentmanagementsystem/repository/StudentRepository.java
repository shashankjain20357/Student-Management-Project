package com.student.studentmanagementsystem.repository;

import com.student.studentmanagementsystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long> {

    
}