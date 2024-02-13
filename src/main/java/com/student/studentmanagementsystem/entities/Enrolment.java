package com.student.studentmanagementsystem.entities;

import jakarta.persistence.*;
public class Enrolment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrolmentId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Long getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(Long enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
}
