package com.student.studentmanagementsystem.repository;

import com.student.studentmanagementsystem.entities.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {
    // Add any custom queries if needed
}
