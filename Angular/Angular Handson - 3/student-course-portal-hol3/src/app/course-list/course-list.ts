import { Component, OnInit } from '@angular/core';
import { NgIf, NgFor } from '@angular/common';
import { CourseCard } from '../course-card/course-card';

@Component({
  selector: 'app-course-list',
  imports: [NgIf, NgFor, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  isLoading = true;

  courses = [
    {
      id: 1,
      name: 'Angular Fundamentals',
      code: 'ANG101',
      credits: 3,
      gradeStatus: 'passed'
    },
    {
      id: 2,
      name: 'Java Programming',
      code: 'JAVA201',
      credits: 4,
      gradeStatus: 'failed'
    },
    {
      id: 3,
      name: 'Database Management',
      code: 'DB301',
      credits: 3,
      gradeStatus: 'pending'
    },
    {
      id: 4,
      name: 'Web Development',
      code: 'WEB401',
      credits: 4,
      gradeStatus: 'passed'
    },
    {
      id: 5,
      name: 'Data Structures',
      code: 'DS501',
      credits: 3,
      gradeStatus: 'pending'
    }
  ];

  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  trackByCourseId(index: number, course: any): number {
    return course.id;
  }
}