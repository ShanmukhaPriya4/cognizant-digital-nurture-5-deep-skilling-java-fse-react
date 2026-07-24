import { Routes } from '@angular/router';

import { authGuard } from './guards/auth.guard';

import { Home } from './pages/home/home';
import { CourseList } from './pages/course-list/course-list';
import { CourseDetail } from './pages/course-detail/course-detail';
import { StudentProfile } from './pages/student-profile/student-profile';
import { CoursesLayout } from './pages/courses-layout/courses-layout';
import { NotFound } from './pages/not-found/not-found';

export const routes: Routes = [

  // Home page
  {
    path: '',
    component: Home
  },

  // Courses with nested routes
  // /courses       -> CourseList
  // /courses/:id   -> CourseDetail
  {
    path: 'courses',
    component: CoursesLayout,
    children: [
      {
        path: '',
        component: CourseList
      },
      {
        path: ':id',
        component: CourseDetail
      }
    ]
  },

  // Student Profile - Protected by Auth Guard
  {
    path: 'profile',
    component: StudentProfile,
    canActivate: [authGuard]
  },

  // Lazy-loaded Enrollment Feature - Protected by Auth Guard
  // /enroll          -> EnrollmentForm
  // /enroll/reactive  -> ReactiveEnrollmentForm
  {
    path: 'enroll',
    canActivate: [authGuard],
    loadChildren: () =>
      import('./features/enrollment/enrollment.module')
        .then(m => m.EnrollmentModule)
  },

  // Wildcard route - must always be last
  {
    path: '**',
    component: NotFound
  }

];