// src/app/api.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private apiUrl = 'http://localhost:8080'; // Replace with your actual backend API URL

  constructor(private http: HttpClient) {}

  getStudents(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/students`);
  }

  getStudentById(studentId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/students/${studentId}`);
  }

  getCourses(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/courses`);
  }

  // Add other methods for API calls as needed
}
