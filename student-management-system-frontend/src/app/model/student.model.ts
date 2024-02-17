// student.model.ts

import { Course } from './course.model';
import { Enrolment } from './enrolment.model';

export interface Student {
  id?: number;
  name?: string;
  email?: string;
  contactNo?: string;
  address?: string;
  courseEnrolled?: Course;
  enrolments?: Enrolment[];
}
