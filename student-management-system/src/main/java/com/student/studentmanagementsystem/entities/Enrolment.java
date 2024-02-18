package com.student.studentmanagementsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity

@Getter
@Setter

public class Enrolment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrolmentId;

    private Long student_id;

    private Long course_id;
    
}
