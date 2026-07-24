import { Component, OnInit } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';

import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-list',
  imports: [
    NgFor,
    NgIf
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  courses: Course[] = [];

  isLoading = true;

  errorMessage = '';

  constructor(
    private courseService: CourseService
  ) {}

  ngOnInit(): void {

    this.loadCourses();

  }

  loadCourses(): void {

    this.isLoading = true;

    this.errorMessage = '';

    this.courseService
      .getCourses()
      .subscribe({

        next: (courses) => {

          this.courses = courses;

        },

        error: (err) => {

          console.error(
            'Error:',
            err
          );

          this.errorMessage =
            err.message ||
            'Failed to load courses.';

          this.isLoading = false;

        },

        complete: () => {

          this.isLoading = false;

        }

      });

  }

}