// enrolment.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Enrolment } from '../model/enrolment.model';

@Injectable({
  providedIn: 'root',
})
export class EnrolmentService {
  private apiUrl = 'http://localhost:8080/api/enrolments'; // Update with your backend URL

  constructor(private http: HttpClient) {}

  getAllEnrolments(): Observable<Enrolment[]> {
    return this.http.get<Enrolment[]>(this.apiUrl);
  }

  getEnrolmentById(enrolmentId: number): Observable<Enrolment> {
    return this.http.get<Enrolment>(`${this.apiUrl}/${enrolmentId}`);
  }

  saveEnrolment(enrolment: Enrolment): Observable<Enrolment> {
    return this.http.post<Enrolment>(this.apiUrl, enrolment);
  }

  deleteEnrolment(enrolmentId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${enrolmentId}`);
  }
}
