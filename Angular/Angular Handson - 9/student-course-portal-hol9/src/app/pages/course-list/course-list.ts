import { Component, OnInit } from '@angular/core';

import {
  AsyncPipe,
  NgFor,
  NgIf
} from '@angular/common';

import {
  Observable
} from 'rxjs';

import {
  Store
} from '@ngrx/store';

import {
  Course
} from '../../models/course.model';

import {
  loadCourses
} from '../../store/course/course.actions';

import {
  selectAllCourses,
  selectCoursesLoading,
  selectCoursesError
} from '../../store/course/course.selectors';

@Component({
  selector: 'app-course-list',

  imports: [
    AsyncPipe,
    NgFor,
    NgIf
  ],

  templateUrl: './course-list.html',

  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  courses$: Observable<Course[]>;

  loading$: Observable<boolean>;

  error$: Observable<string | null>;

  constructor(
    private store: Store
  ) {

    this.courses$ =
      this.store.select(selectAllCourses);

    this.loading$ =
      this.store.select(selectCoursesLoading);

    this.error$ =
      this.store.select(selectCoursesError);

  }

  ngOnInit(): void {

    // Dispatch the action to load courses.
    // The NgRx Effect will call the API.
    this.store.dispatch(
      loadCourses()
    );

  }

}
