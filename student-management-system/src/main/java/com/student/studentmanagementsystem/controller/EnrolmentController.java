package com.student.studentmanagementsystem.controller;

// import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.studentmanagementsystem.entities.Enrolment;
import com.student.studentmanagementsystem.service.EnrolmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/enrolments")
public class EnrolmentController {

    @Autowired
    private EnrolmentService enrolmentService;

    // @GetMapping
    // public List<Enrolment> getAllEnrolments() {
    //     return enrolmentService.getAllEnrolments();
    // }

    // @GetMapping("/{enrolmentId}")
    // public ResponseEntity<Enrolment> getEnrolmentById(@PathVariable Long enrolmentId) {
    //     Optional<Enrolment> enrolment = enrolmentService.getEnrolmentById(enrolmentId);
    //     return enrolment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    // }

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
