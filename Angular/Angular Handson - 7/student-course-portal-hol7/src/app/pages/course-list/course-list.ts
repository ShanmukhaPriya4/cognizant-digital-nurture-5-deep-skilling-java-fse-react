import { Component, OnInit } from '@angular/core';
import { NgFor } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  Router,
  ActivatedRoute,
  RouterLink
} from '@angular/router';

import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-list',
  imports: [
    NgFor,
    FormsModule,
    RouterLink
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList implements OnInit {

  courses: Course[] = [];

  searchTerm = '';

  constructor(
    private courseService: CourseService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {

    // Load courses from CourseService
    this.courses = this.courseService.getCourses();

    // Read the search query parameter from the URL
    // Example: /courses?search=angular
    this.searchTerm =
      this.route.snapshot.queryParamMap.get('search') || '';

  }

  searchCourses(): void {

    // Update the URL with the search query parameter
    this.router.navigate(
      ['courses'],
      {
        queryParams: {
          search: this.searchTerm
        }
      }
    );

  }

}