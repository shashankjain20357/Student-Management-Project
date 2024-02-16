// app.routes.ts

import { Routes } from '@angular/router';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { CourseListComponent } from './course-list/course-list.component';
import { EnrolmentListComponent } from './enrolment-list/enrolment-list.component';

export const routes: Routes = [
  { path: 'students', component: StudentListComponent },
  { path: 'students/:id', component: StudentDetailsComponent },
  { path: 'courses', component: CourseListComponent },
  { path: 'enrolments', component: EnrolmentListComponent },
  // Add more routes as needed for additional components or features
];
