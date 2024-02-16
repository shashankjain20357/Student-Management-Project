// enrolment-list.component.ts

import { Component, OnInit } from '@angular/core';
import { EnrolmentService } from '../services/enrolment.service';
import { Enrolment } from '../model/enrolment.model';

@Component({
  selector: 'app-enrolment-list',
  templateUrl: './enrolment-list.component.html',
  styleUrls: ['./enrolment-list.component.css'],
})
export class EnrolmentListComponent implements OnInit {
  enrolments: Enrolment[] = []; // Initialize the property

  constructor(private enrolmentService: EnrolmentService) {}

  ngOnInit(): void {
    this.loadEnrolments();
  }

  loadEnrolments(): void {
    this.enrolmentService.getAllEnrolments().subscribe((enrolments) => {
      this.enrolments = enrolments;
    });
  }
}
