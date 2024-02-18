// course.model.ts

import { Student } from './student.model';

export interface Course {
  courseId?: number;
  courseName?: string;
  duration?: string;
  students?: Student[];
}
