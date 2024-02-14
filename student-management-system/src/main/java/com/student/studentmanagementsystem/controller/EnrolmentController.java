package com.student.studentmanagementsystem.controller;

import org.springframework.web.bind.annotation.*;

import com.student.studentmanagementsystem.entities.Enrolment;
import com.student.studentmanagementsystem.service.EnrolmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrolments")

public class EnrolmentController {
    private final EnrolmentService enrolmentService;

    public EnrolmentController(EnrolmentService enrolmentService) {
        this.enrolmentService = enrolmentService;
    }

    @GetMapping
    public List<Enrolment> getAllEnrolments() {
        return enrolmentService.getAllEnrolments();
    }

    @GetMapping("/{enrolmentId}")
    public Optional<Enrolment> getEnrolmentById(@PathVariable Long enrolmentId) {
        return enrolmentService.getEnrolmentById(enrolmentId);
    }

    @PostMapping
    public Enrolment saveEnrolment(@RequestBody Enrolment enrolment) {
        return enrolmentService.saveEnrolment(enrolment);
    }

    @DeleteMapping("/{enrolmentId}")
    public void deleteEnrolment(@PathVariable Long enrolmentId) {
        enrolmentService.deleteEnrolment(enrolmentId);
    }
}
