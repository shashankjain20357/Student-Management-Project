// enrolment-list.component.ts

import { Component, OnInit } from '@angular/core';
import { Enrolment } from '../model/enrolment.model';
import { EnrolmentService } from '../services/enrolment.service';

@Component({
  selector: 'app-enrolment-list',
  templateUrl: './enrolment-list.component.html',
  styleUrls: ['./enrolment-list.component.css'],
})
export class EnrolmentListComponent implements OnInit {
  enrolments: Enrolment[] = [];

  constructor(private enrolmentService: EnrolmentService) {}

  ngOnInit(): void {
    this.loadEnrolments();
  }

  private loadEnrolments(): void {
    this.enrolmentService.getAllEnrolments().subscribe((data) => {
      this.enrolments = data;
    });
  }
}
