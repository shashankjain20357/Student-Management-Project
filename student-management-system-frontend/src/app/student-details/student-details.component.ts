// student-details.component.ts

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
    });
  }

  saveStudent(): void {
    this.studentService.saveStudent(this.student).subscribe(() => {
      this.router.navigate(['/students']);
    });
  }

  updateStudent(): void {
    if (this.student.id) {
      this.studentService
        .updateStudent(this.student.id, this.student)
        .subscribe(() => {
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
