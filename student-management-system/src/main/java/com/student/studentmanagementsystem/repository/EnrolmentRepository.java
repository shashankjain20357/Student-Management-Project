package com.student.studentmanagementsystem.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.studentmanagementsystem.entities.Enrolment;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {
    @Query(value = "SELECT * From enrolment e where e.student_id= ?1",
    nativeQuery = true)
    public List<Enrolment> getEnrolmentByStudentId(Long student_id);

    @Query(value = "SELECT * From enrolment e where e.course_id= ?1",
    nativeQuery = true)
    public List<Enrolment> getEnrolmentByCourseId(Long course_id);

}
