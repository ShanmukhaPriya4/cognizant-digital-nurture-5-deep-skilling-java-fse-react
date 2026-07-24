import { createReducer, on } from '@ngrx/store';

import {
  enrollInCourse,
  unenrollFromCourse,
  setEnrolledCourses
} from './enrollment.actions';

export interface EnrollmentState {
  enrolledCourseIds: number[];
}

export const initialState: EnrollmentState = {
  enrolledCourseIds: []
};

export const enrollmentReducer = createReducer(

  initialState,

  on(
    enrollInCourse,
    (state, { courseId }) => {

      if (state.enrolledCourseIds.includes(courseId)) {
        return state;
      }

      return {
        ...state,
        enrolledCourseIds: [
          ...state.enrolledCourseIds,
          courseId
        ]
      };

    }
  ),

  on(
    unenrollFromCourse,
    (state, { courseId }) => ({
      ...state,

      enrolledCourseIds:
        state.enrolledCourseIds.filter(
          id => id !== courseId
        )
    })
  ),

  on(
    setEnrolledCourses,
    (state, { courseIds }) => ({
      ...state,
      enrolledCourseIds: courseIds
    })
  )

);