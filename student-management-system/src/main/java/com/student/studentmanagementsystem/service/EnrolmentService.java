package com.student.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.student.studentmanagementsystem.entities.Enrolment;
import com.student.studentmanagementsystem.repository.EnrolmentRepository;

@Service
public class EnrolmentService {
    private final EnrolmentRepository enrolmentRepository;

    public EnrolmentService(EnrolmentRepository enrolmentRepository) {
        this.enrolmentRepository = enrolmentRepository;
    }

    public List<Enrolment> getAllEnrolments() {
        return enrolmentRepository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<Enrolment> getEnrolmentById(Long enrolmentId) {
        return enrolmentRepository.findById(enrolmentId);
    }

    public Enrolment saveEnrolment(Enrolment enrolment) {
        enrolment.setStudent(null);
        enrolment.setCourse(null);
        return enrolmentRepository.save(enrolment);
    }

    @SuppressWarnings("null")
    public void deleteEnrolment(Long enrolmentId) {
        enrolmentRepository.deleteById(enrolmentId);
    }
}
