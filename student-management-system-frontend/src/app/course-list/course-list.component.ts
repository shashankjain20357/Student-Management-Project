// course-list.component.ts

import { Component, OnInit } from '@angular/core';
import { Course } from '../model/course.model';
import { CourseService } from '../services/course.service';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css'],
})
export class CourseListComponent implements OnInit {
  courses: Course[] = [];
  showForm = false;
  newCourse: Course = {};
  editedCourse: Course = {};

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    this.loadCourses();
  }

  loadCourses(): void {
    this.courseService.getAllCourses().subscribe((data) => {
      this.courses = data;
    });
  }

  showAddCourseForm(): void {
    this.showForm = true;
  }

  addCourse(): void {
    this.courseService.addCourse(this.newCourse).subscribe(() => {
      this.loadCourses();
      this.showForm = false;
      this.newCourse = {};
    });
  }

  updateCourse(courseId: number | undefined): void {
    if (courseId !== undefined) {
    
      const originalCourse = this.courses.find((course) => course.courseId === courseId);

      if (!this.editedCourse || this.editedCourse.courseId !== courseId) {
        this.editedCourse = { ...originalCourse };
      } else {
        
        this.courseService.updateCourse(courseId, this.editedCourse).subscribe(() => {
          this.loadCourses();
          this.editedCourse = {};
        });
      }
    }
  }

  deleteCourse(courseId: number | undefined): void {
    if (courseId !== undefined) {
      this.courseService.deleteCourse(courseId).subscribe(() => {
        this.loadCourses();
      });
    }
  }
}
