import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private apiUrl = 'http://localhost:3000/courses';

  constructor(
    private http: HttpClient
  ) {}

  // Get all courses
  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.apiUrl);
  }

  // Get one course by ID
  getCourseById(
    id: number
  ): Observable<Course> {

    return this.http.get<Course>(
      `${this.apiUrl}/${id}`
    );

  }

  // Create a new course
  createCourse(
    course: Omit<Course, 'id'>
  ): Observable<Course> {

    return this.http.post<Course>(
      this.apiUrl,
      course
    );

  }

  // Update a course
  updateCourse(
    id: number,
    course: Partial<Course>
  ): Observable<Course> {

    return this.http.put<Course>(
      `${this.apiUrl}/${id}`,
      course
    );

  }

  // Delete a course
  deleteCourse(
    id: number
  ): Observable<void> {

    return this.http.delete<void>(
      `${this.apiUrl}/${id}`
    );

  }

}