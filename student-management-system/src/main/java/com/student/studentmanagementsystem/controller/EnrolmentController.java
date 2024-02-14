package com.student.studentmanagementsystem.controller;

import com.student.studentmanagementsystem.entities.Enrolment;
import com.student.studentmanagementsystem.service.EnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrolments")
public class EnrolmentController {

    private final EnrolmentService enrolmentService;

    @Autowired
    public EnrolmentController(EnrolmentService enrolmentService) {
        this.enrolmentService = enrolmentService;
    }

    @GetMapping
    public List<Enrolment> getAllEnrolments() {
        return enrolmentService.getAllEnrolments();
    }

    @GetMapping("/{enrolmentId}")
    public ResponseEntity<Enrolment> getEnrolmentById(@PathVariable Long enrolmentId) {
        Optional<Enrolment> enrolment = enrolmentService.getEnrolmentById(enrolmentId);
        return enrolment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Enrolment> saveEnrolment(@RequestBody Enrolment enrolment) {
        Enrolment savedEnrolment = enrolmentService.saveEnrolment(enrolment);
        return ResponseEntity.ok(savedEnrolment);
    }

    @DeleteMapping("/{enrolmentId}")
    public ResponseEntity<Void> deleteEnrolment(@PathVariable Long enrolmentId) {
        enrolmentService.deleteEnrolment(enrolmentId);
        return ResponseEntity.noContent().build();
    }
}
