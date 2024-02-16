// student-details.component.ts

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../services/student.service';
import { Student } from '../model/student.model';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css'],
})
export class StudentDetailsComponent implements OnInit {
  student!: Student;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private studentService: StudentService
  ) {}

  ngOnInit(): void {
    const studentIdString = this.route.snapshot.paramMap.get('id');
    const studentId = studentIdString ? +studentIdString : null;

    if (studentId !== null) {
      this.loadStudentDetails(studentId);
    } else {
      // Handle the case when 'id' is null (e.g., redirect to an error page or home page)
      console.error('Student ID is null.');
    }
    
  }

  loadStudentDetails(studentId: number): void {
    this.studentService.getStudentById(studentId).subscribe((student) => {
      this.student = student;
    });
  }

  editStudent(): void {
    // Navigate to the edit page, passing the student id
    this.router.navigate(['/students', this.student.id, 'edit']);
  }

  saveStudentChanges(): void {
    // Call the updateStudent method from the service
    this.studentService.updateStudent(this.student.id, this.student).subscribe(
      () => {
        console.log('Student details updated successfully.');
        // You can navigate to a different page or perform any other action upon successful update
      },
      (error) => {
        console.error('Error updating student details:', error);
        // Handle error scenarios if needed
      }
    );
  }
}
