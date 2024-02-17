// student-list.component.ts

import { Component, OnInit } from '@angular/core';
import { Student } from '../model/student.model';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
})
export class StudentListComponent implements OnInit {
  students: Student[] = [];

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.loadStudents();
  }

  private loadStudents(): void {
    this.studentService.getAllStudents().subscribe((data) => {
      this.students = data;
    });
  }
}
