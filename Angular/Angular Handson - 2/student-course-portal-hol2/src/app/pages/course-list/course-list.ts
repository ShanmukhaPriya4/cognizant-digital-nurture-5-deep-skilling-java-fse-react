import { Component } from '@angular/core';
import { CourseCard } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  imports: [CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList {

  courses = [
    {
      id: 1,
      name: 'Angular Fundamentals',
      code: 'ANG101',
      credits: 3
    },
    {
      id: 2,
      name: 'Java Programming',
      code: 'JAVA201',
      credits: 4
    },
    {
      id: 3,
      name: 'Database Management',
      code: 'DB301',
      credits: 3
    },
    {
      id: 4,
      name: 'Web Development',
      code: 'WEB401',
      credits: 3
    },
    {
      id: 5,
      name: 'Data Structures',
      code: 'DS501',
      credits: 4
    }
  ];

  selectedCourseId: number | null = null;

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}