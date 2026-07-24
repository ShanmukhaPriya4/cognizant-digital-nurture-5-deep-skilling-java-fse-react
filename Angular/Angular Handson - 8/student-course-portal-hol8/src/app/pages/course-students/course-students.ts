import { Component, OnInit } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Subject } from 'rxjs';
import { switchMap } from 'rxjs/operators';

import { EnrollmentService } from '../../services/enrollment';
import { Student } from '../../models/student.model';

@Component({
  selector: 'app-course-students',
  imports: [
    NgFor,
    NgIf
  ],
  templateUrl: './course-students.html',
  styleUrl: './course-students.css'
})
export class CourseStudents implements OnInit {

  students: Student[] = [];

  isLoading = false;

  errorMessage = '';

  private courseId$ = new Subject<number>();

  constructor(
    private enrollmentService: EnrollmentService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {

    // switchMap is used for dependent HTTP calls.
    //
    // When a new courseId arrives, switchMap cancels
    // the previous inner Observable and subscribes to
    // the latest HTTP request.
    //
    // This prevents an older HTTP response from
    // overwriting the result for the newly selected course.

    this.courseId$
      .pipe(
        switchMap(courseId => {

          this.isLoading = true;

          this.errorMessage = '';

          return this.enrollmentService
            .getStudentsByCourse(courseId);

        })
      )
      .subscribe({

        next: (students) => {

          this.students = students;

          this.isLoading = false;

        },

        error: (err) => {

          console.error(
            'Error loading students:',
            err
          );

          this.errorMessage =
            'Failed to load students.';

          this.isLoading = false;

        }

      });

    // Read the course ID from the URL.
    this.route.paramMap.subscribe(params => {

      const id = params.get('id');

      if (id) {

        this.courseId$.next(
          Number(id)
        );

      }

    });

  }

}
