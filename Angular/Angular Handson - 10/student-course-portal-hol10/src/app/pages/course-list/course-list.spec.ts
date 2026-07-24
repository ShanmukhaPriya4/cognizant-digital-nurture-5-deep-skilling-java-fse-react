import {
  ComponentFixture,
  TestBed
} from '@angular/core/testing';

import {
  provideMockStore,
  MockStore
} from '@ngrx/store/testing';

import { CourseList } from './course-list';

import { Course } from '../../models/course.model';

describe('CourseList', () => {

  let component: CourseList;
  let fixture: ComponentFixture<CourseList>;
  let store: MockStore;

  const mockCourses: Course[] = [

    {
      id: 1,
      name: 'Data Structures',
      code: 'CS101',
      credits: 4,
      gradeStatus: 'passed'
    },

    {
      id: 2,
      name: 'Database Management',
      code: 'CS102',
      credits: 3,
      gradeStatus: 'pending'
    }

  ];

  const initialState = {

    course: {
      courses: mockCourses,
      loading: false,
      error: null
    }

  };

  beforeEach(async () => {

    await TestBed.configureTestingModule({

      imports: [
        CourseList
      ],

      providers: [

        provideMockStore({
          initialState
        })

      ]

    }).compileComponents();

    fixture =
      TestBed.createComponent(CourseList);

    component =
      fixture.componentInstance;

    store =
      TestBed.inject(MockStore);

    fixture.detectChanges();

  });

  // Test 1: Component creation
  it('should create', () => {

    expect(component)
      .toBeTruthy();

  });

  // Test 2: Courses should be displayed
  it('should display courses from the store', () => {

    const compiled =
      fixture.nativeElement;

    expect(
      compiled.textContent
    ).toContain('Data Structures');

    expect(
      compiled.textContent
    ).toContain('Database Management');

  });

  // Test 3: Loading indicator should be displayed
  it('should display the loading indicator', () => {

    store.setState({

      course: {
        courses: [],
        loading: true,
        error: null
      }

    });

    fixture.detectChanges();

    const compiled =
      fixture.nativeElement;

    expect(
      compiled.textContent
    ).toContain('Loading courses...');

  });

  // Test 4: Error message should be displayed
  it('should display an error message', () => {

    store.setState({

      course: {
        courses: [],
        loading: false,
        error: 'Failed to load courses'
      }

    });

    fixture.detectChanges();

    const compiled =
      fixture.nativeElement;

    expect(
      compiled.textContent
    ).toContain('Failed to load courses');

  });

  // Test 5: loadCourses action should be dispatched
  it('should dispatch loadCourses action on initialization', () => {

    const dispatchSpy =
      spyOn(store, 'dispatch');

    component.ngOnInit();

    expect(
      dispatchSpy
    ).toHaveBeenCalled();

  });

});