// src/app/student-list/student-list.component.ts

import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
})
export class StudentListComponent implements OnInit {
  students: any[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.apiService.getStudents().subscribe(
      (data: any[]) => {
        this.students = data;
      },
      (error) => {
        console.error('Error fetching students:', error);
        // Optionally, you can show a user-friendly message or perform other error handling here.
      }
    );
  }
}
