import { Routes } from '@angular/router';
import { EnrolmentComponent } from "../course-list/course-list.componentls.component";
import { CourseListComponent } from './components/course-list/course-list.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { StudentListComponent } from './student-list/student-list.component';

export const routes: Routes = [
  { path: 'students', component: StudentListComponent },
  { path: 'students/:id', component: StudentDetailsComponent },
  { path: 'courses', component: CourseListComponent },
  { path: 'enrolment', component: EnrolmentComponent },
  { path: '', redirectTo: '/students', pathMatch: 'full' },
];