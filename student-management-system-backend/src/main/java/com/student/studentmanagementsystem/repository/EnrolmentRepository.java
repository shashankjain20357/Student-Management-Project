package com.student.studentmanagementsystem.repository;

import com.student.studentmanagementsystem.entities.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Long>{
    
}
