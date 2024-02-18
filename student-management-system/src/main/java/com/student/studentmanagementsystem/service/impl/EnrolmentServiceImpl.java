package com.student.studentmanagementsystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.studentmanagementsystem.entities.Enrolment;
import com.student.studentmanagementsystem.repository.EnrolmentRepository;
import com.student.studentmanagementsystem.service.EnrolmentService;

@Service
public class EnrolmentServiceImpl implements EnrolmentService {

    @Autowired
    private EnrolmentRepository enrolmentRepository;

    @Override
    public List<Enrolment> getAllEnrolments() {
        return enrolmentRepository.findAll();
    }

    @Override
    public Optional<Enrolment> getEnrolmentById(Long enrolmentId) {
        return enrolmentRepository.findById(enrolmentId);
    }

    @Override
    public Enrolment saveEnrolment(Enrolment enrolment) {
        // Add any validation or business logic before saving
        return enrolmentRepository.save(enrolment);
    }

    @Override
    public void deleteEnrolment(Long enrolmentId) {
        enrolmentRepository.deleteById(enrolmentId);
    }

    @Override
    public List<Enrolment> enrolmentByStudentId(Long student_id) {
        return enrolmentRepository.getEnrolmentByStudentId(student_id);
    }

    @Override
    public List<Enrolment> enrolmentByCourseId(Long course_id) {
        return enrolmentRepository.getEnrolmentByCourseId(course_id);
    }
}
