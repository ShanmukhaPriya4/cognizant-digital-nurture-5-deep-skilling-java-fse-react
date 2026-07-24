import { Routes } from '@angular/router';

import { CourseList } from './pages/course-list/course-list';
import { CourseStudents } from './pages/course-students/course-students';

// Add these imports only if these components exist in your project
// import { Home } from './pages/home/home';
// import { CourseDetail } from './pages/course-detail/course-detail';
// import { StudentProfile } from './pages/student-profile/student-profile';
// import { NotFound } from './pages/not-found/not-found';

export const routes: Routes = [

  // Home
  // Uncomment if Home component exists
  // {
  //   path: '',
  //   component: Home
  // },

  // Course List
  {
    path: 'courses',
    component: CourseList
  },

  // Students enrolled in a specific course
  // Example: /courses/1/students
  {
    path: 'courses/:id/students',
    component: CourseStudents
  },

  // Add your other routes here if those components exist

  // Wildcard route - keep this LAST
  // {
  //   path: '**',
  //   component: NotFound
  // }

];
