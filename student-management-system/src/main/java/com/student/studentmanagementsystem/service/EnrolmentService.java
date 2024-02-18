package com.student.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.student.studentmanagementsystem.entities.Enrolment;

public interface EnrolmentService {
    List<Enrolment> getAllEnrolments();
    Optional<Enrolment> getEnrolmentById(Long enrolmentId);
    Enrolment saveEnrolment(Enrolment enrolment);
    void deleteEnrolment(Long enrolmentId);
    List<Enrolment> enrolmentByStudentId(Long student_id);
    public List<Enrolment> enrolmentByCourseId(Long coursed) ;
}
