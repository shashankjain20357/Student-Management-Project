package com.student.studentmanagementsystem.entities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String name;
    private String email;
    private String contactNo;
    private String address;
    private List<Course> courseEnrolled;
}
