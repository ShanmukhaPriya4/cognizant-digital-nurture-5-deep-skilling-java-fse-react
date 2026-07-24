import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Student } from '../models/student.model';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {

  private studentsApiUrl =
    'http://localhost:3000/students';

  constructor(
    private http: HttpClient
  ) {}

  // Gets students enrolled in a specific course.
  getStudentsByCourse(
    courseId: number
  ): Observable<Student[]> {

    return this.http.get<Student[]>(
      `${this.studentsApiUrl}?courseId=${courseId}`
    );

  }

}