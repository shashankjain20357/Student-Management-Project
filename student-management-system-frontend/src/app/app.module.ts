// app.module.ts

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { CourseListComponent } from './course-list/course-list.component';
import { EnrolmentListComponent } from './enrolment-list/enrolment-list.component';

@NgModule({
  
  declarations: [
    AppComponent,
    StudentListComponent,
    StudentDetailsComponent,
    CourseListComponent,
    EnrolmentListComponent,
    // Add more components as needed
  ],

  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  
  providers: [],
  bootstrap: [AppComponent],
})

export class AppModule {}
