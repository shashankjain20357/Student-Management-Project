// student-details.component.ts

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../model/course.model';
import { Student } from '../model/student.model';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css'],
})
export class StudentDetailsComponent implements OnInit {
  student: Student = {};

  constructor(
    private studentService: StudentService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const studentId = this.route.snapshot.params['id'];
    if (studentId) {
      this.loadStudent(studentId);
    }
  }

  private loadStudent(id: number): void {
    this.studentService.getStudentById(id).subscribe((data) => {
      this.student = data;
      this.student.course = this.getAllCourseName(data?.courseEnrolled);
    });
  }

  getAllCourseName(courseEnrolled:any): string {
    let res = ""
    let courseList: Course[] =courseEnrolled || []
    courseList.forEach(element => {
      res = res+" "+ element?.courseName
    });
    return res;
  }

  saveStudent(): void {
    this.studentService.saveStudent(this.student).subscribe(() => {
      this.router.navigate(['/students']);
    });
  }

  updateStudent(): void {
    if (this.student.id) {
      const updatedStudent: Student = {
        id: this.student.id,
        name: this.student.name,
        email: this.student.email,
        contactNo: this.student.contactNo,
        address: this.student.address,
      };

      this.studentService.updateStudent(this.student.id, updatedStudent).subscribe(() => {
        this.router.navigate(['/students']);
      });
    }
  }

  deleteStudent(): void {
    if (this.student.id) {
      this.studentService.deleteStudent(this.student.id).subscribe(() => {
        this.router.navigate(['/students']);
      });
    }
  }
}
