import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {
  Observable,
  throwError
} from 'rxjs';

import {
  map,
  tap,
  retry,
  catchError
} from 'rxjs/operators';

import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private apiUrl = 'http://localhost:3000/courses';

  constructor(
    private http: HttpClient
  ) {}

  // GET all courses
  getCourses(): Observable<Course[]> {

    return this.http
      .get<Course[]>(this.apiUrl)

      // map is used to transform the response.
      // Here, only courses with credits greater than 0 are returned.
      .pipe(
        map(courses =>
          courses.filter(course => course.credits > 0)
        ),

        // tap is used for side effects such as logging.
        // It does not modify the data flowing through the Observable.
        // map should be used when we want to transform data.
        tap(courses =>
          console.log(
            'Courses loaded:',
            courses.length
          )
        ),

        // Retry the HTTP request two more times
        // if the first request fails.
        retry(2),

        // Handle the error after all retry attempts fail.
        catchError(err => {

          console.error(
            'Course API Error:',
            err
          );

          return throwError(
            () =>
              new Error(
                'Failed to load courses. Please try again.'
              )
          );

        })
      );
  }

  // GET course by ID
  getCourseById(
    id: number
  ): Observable<Course> {

    return this.http.get<Course>(
      `${this.apiUrl}/${id}`
    ).pipe(

      retry(2),

      catchError(err => {

        console.error(
          'Error loading course:',
          err
        );

        return throwError(
          () =>
            new Error(
              'Failed to load course details.'
            )
        );

      })

    );
  }

  // POST - Create course
  createCourse(
    course: Omit<Course, 'id'>
  ): Observable<Course> {

    return this.http.post<Course>(
      this.apiUrl,
      course
    ).pipe(

      catchError(err => {

        console.error(
          'Error creating course:',
          err
        );

        return throwError(
          () =>
            new Error(
              'Failed to create course.'
            )
        );

      })

    );
  }

  // PUT - Update course
  updateCourse(
    id: number,
    course: Course
  ): Observable<Course> {

    return this.http.put<Course>(
      `${this.apiUrl}/${id}`,
      course
    );

  }

  // DELETE - Delete course
  deleteCourse(
    id: number
  ): Observable<void> {

    return this.http.delete<void>(
      `${this.apiUrl}/${id}`
    );

  }

}