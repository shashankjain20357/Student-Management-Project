package com.student.studentmanagementsystem.service;

import com.student.studentmanagementsystem.entities.Enrolment;
import com.student.studentmanagementsystem.repository.EnrolmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrolmentServiceImpl implements EnrolmentService {

    private final EnrolmentRepository enrolmentRepository;

    @Autowired
    public EnrolmentServiceImpl(EnrolmentRepository enrolmentRepository) {
        this.enrolmentRepository = enrolmentRepository;
    }

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
}
