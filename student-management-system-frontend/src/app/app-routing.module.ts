// app-routing.module.ts

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { CourseListComponent } from './course-list/course-list.component';
import { EnrolmentListComponent } from './enrolment-list/enrolment-list.component';

const routes: Routes = [
  { path: 'students', component: StudentListComponent },
  { path: 'students/:id', component: StudentDetailsComponent },
  { path: 'courses', component: CourseListComponent },
  { path: 'enrolments', component: EnrolmentListComponent },
  // Add other routes as needed
  { path: '', redirectTo: '/students', pathMatch: 'full' }, // Default route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
