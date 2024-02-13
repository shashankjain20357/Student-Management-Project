package com.student.studentmanagementsystem.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private int contactNo;
    private String address;

    @ManyToOne
    @JoinColumn(name = "course_enrolled_id")
    private Course courseEnrolled;

    @OneToMany(mappedBy = "student")
    private List<Enrolment> enrolments;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Course getCourseEnrolled() {
        return courseEnrolled;
    }

    public void setCourseEnrolled(Course courseEnrolled) {
        this.courseEnrolled = courseEnrolled;
    }

    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(List<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }
    
}
