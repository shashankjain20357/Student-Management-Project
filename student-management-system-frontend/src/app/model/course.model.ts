// course.model.ts

import { Student } from './student.model';
import { Enrolment } from './enrolment.model';

export interface Course {
  courseId?: number;
  courseName?: string;
  duration?: string;
  students?: Student[];
  enrolments?: Enrolment[];
}
