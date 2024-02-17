// enrolment.model.ts

import { Student } from './student.model';
import { Course } from './course.model';

export interface Enrolment {
  enrolmentId?: number;
  student?: Student;
  course?: Course;
}
