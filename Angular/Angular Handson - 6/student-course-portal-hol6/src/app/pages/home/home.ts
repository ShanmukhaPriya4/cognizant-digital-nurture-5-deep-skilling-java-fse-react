import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit {

  courseCount = 0;

  constructor(
    private courseService: CourseService
  ) {}

  ngOnInit(): void {
    this.updateCourseCount();
  }

  updateCourseCount(): void {
    this.courseCount = this.courseService.getCourses().length;
  }

  addNewCourse(): void {

    const newCourse: Course = {
      id: 6,
      name: 'Artificial Intelligence',
      code: 'AI101',
      credits: 4,
      gradeStatus: 'pending'
    };

    this.courseService.addCourse(newCourse);

    this.updateCourseCount();
  }

}