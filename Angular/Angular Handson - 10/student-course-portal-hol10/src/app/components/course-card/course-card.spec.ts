import {
  ComponentFixture,
  TestBed
} from '@angular/core/testing';

import {
  By
} from '@angular/platform-browser';

import { CourseCard } from './course-card';

import { Course } from '../../models/course.model';

describe('CourseCard', () => {

  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;

  const mockCourse: Course = {
    id: 1,
    name: 'Data Structures',
    code: 'CS101',
    credits: 4,
    gradeStatus: 'passed'
  };

  beforeEach(async () => {

    await TestBed.configureTestingModule({

      imports: [
        CourseCard
      ]

    }).compileComponents();

    fixture =
      TestBed.createComponent(CourseCard);

    component =
      fixture.componentInstance;

    component.course =
      mockCourse;

    fixture.detectChanges();

  });

  // Test 1: Component should be created
  it('should create', () => {

    expect(component).toBeTruthy();

  });

  // Test 2: Course name should be displayed
  it('should display the course name', () => {

    const heading =
      fixture.debugElement
        .query(By.css('h2'))
        .nativeElement;

    expect(
      heading.textContent
    ).toContain('Data Structures');

  });

  // Test 3: Course code should be displayed
  it('should display the course code', () => {

    const heading =
      fixture.debugElement
        .query(By.css('h3'))
        .nativeElement;

    expect(
      heading.textContent
    ).toContain('CS101');

  });

  // Test 4: Credits should be displayed
  it('should display the course credits', () => {

    const paragraphs =
      fixture.debugElement
        .queryAll(By.css('p'));

    expect(
      paragraphs[0].nativeElement.textContent
    ).toContain('4');

  });

  // Test 5: Grade status should be displayed
  it('should display the grade status', () => {

    const paragraphs =
      fixture.debugElement
        .queryAll(By.css('p'));

    expect(
      paragraphs[1].nativeElement.textContent
    ).toContain('passed');

  });

});