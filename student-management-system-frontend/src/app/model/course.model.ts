// course.model.ts

export interface Course {
    courseId: number;
    courseName: string;
    duration: string;
    students?: any[]; // Adjust as per your backend model
  }
  