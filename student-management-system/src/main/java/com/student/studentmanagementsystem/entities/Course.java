package com.student.studentmanagementsystem.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;
    private String duration;

    @OneToMany(mappedBy = "courseEnrolled")
    private List<Student> students;

    @OneToMany(mappedBy = "course")
    private List<Enrolment> enrolments;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(List<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }
}
