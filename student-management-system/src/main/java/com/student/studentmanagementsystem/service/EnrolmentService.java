package com.student.studentmanagementsystem.service;

import com.student.studentmanagementsystem.entities.Enrolment;

import java.util.List;
import java.util.Optional;

public interface EnrolmentService {
    List<Enrolment> getAllEnrolments();
    Optional<Enrolment> getEnrolmentById(Long enrolmentId);
    Enrolment saveEnrolment(Enrolment enrolment);
    void deleteEnrolment(Long enrolmentId);
}
