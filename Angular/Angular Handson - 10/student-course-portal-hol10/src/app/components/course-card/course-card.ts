import { Component, Input } from '@angular/core';
import { AsyncPipe } from '@angular/common';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';

import { Course } from '../../models/course.model';

import {
  enrollInCourse,
  unenrollFromCourse
} from '../../store/enrollment/enrollment.actions';

import {
  selectEnrolledIds
} from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-course-card',
  imports: [AsyncPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard {

  @Input() course!: Course;

  enrolledIds$: Observable<number[]>;

  constructor(
    private store: Store
  ) {
    this.enrolledIds$ =
      this.store.select(selectEnrolledIds);
  }

  toggleEnrollment(): void {

    this.enrolledIds$
      .subscribe(enrolledIds => {

        if (enrolledIds.includes(this.course.id)) {

          this.store.dispatch(
            unenrollFromCourse({
              courseId: this.course.id
            })
          );

        } else {

          this.store.dispatch(
            enrollInCourse({
              courseId: this.course.id
            })
          );

        }

      })
      .unsubscribe();

  }

}