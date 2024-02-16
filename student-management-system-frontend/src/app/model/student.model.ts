// student.model.ts

export interface Student {
    id: number;
    name: string;
    email: string;
    contactNo: string;
    address: string;
    courseEnrolled?: any; // Adjust as per your backend model
  }
  