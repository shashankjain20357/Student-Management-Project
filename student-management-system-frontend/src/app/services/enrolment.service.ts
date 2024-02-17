// enrolment.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Enrolment } from '../model/enrolment.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class EnrolmentService {
  // private apiUrl = 'http://localhost:8080/api/enrolments';
  private apiUrl = `${environment.apiUrl}/enrolments`;


  constructor(private http: HttpClient) {}

  getAllEnrolments(): Observable<Enrolment[]> {
    return this.http.get<Enrolment[]>(this.apiUrl);
  }

  getEnrolmentById(id: number): Observable<Enrolment> {
    return this.http.get<Enrolment>(`${this.apiUrl}/${id}`);
  }

  saveEnrolment(enrolment: Enrolment): Observable<Enrolment> {
    return this.http.post<Enrolment>(this.apiUrl, enrolment);
  }

  deleteEnrolment(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
