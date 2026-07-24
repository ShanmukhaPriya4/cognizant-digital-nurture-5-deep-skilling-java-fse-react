import { Component, OnInit } from '@angular/core';

import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  FormArray,
  FormControl,
  Validators,
  AbstractControl,
  ValidationErrors
} from '@angular/forms';

import { NgIf, NgFor } from '@angular/common';


// =====================================================
// Custom Synchronous Validator
// Rejects course IDs that start with "XX"
// Example: XX101 → Error
// Example: CS101 → Valid
// =====================================================

function noCourseCode(
  control: AbstractControl
): ValidationErrors | null {

  const value = control.value;

  if (
    value &&
    value.toString().startsWith('XX')
  ) {
    return {
      noCourseCode: true
    };
  }

  return null;
}


// =====================================================
// Custom Asynchronous Validator
// Simulates checking whether an email is already taken
// test@example.com → Email taken
// Other emails → Valid
// Validation happens after 800ms
// =====================================================

function simulateEmailCheck(
  control: AbstractControl
): Promise<ValidationErrors | null> {

  return new Promise((resolve) => {

    setTimeout(() => {

      const email = control.value;

      if (
        email &&
        email.includes('test@')
      ) {

        resolve({
          emailTaken: true
        });

      } else {

        resolve(null);

      }

    }, 800);

  });
}


// =====================================================
// Component
// =====================================================

@Component({
  selector: 'app-reactive-enrollment-form',

  imports: [
    ReactiveFormsModule,
    NgIf,
    NgFor
  ],

  templateUrl: './reactive-enrollment-form.html',

  styleUrl: './reactive-enrollment-form.css'
})


export class ReactiveEnrollmentForm
  implements OnInit {


  // Main Reactive Form
  enrollForm!: FormGroup;


  // FormBuilder Injection
  constructor(
    private fb: FormBuilder
  ) {}


  // =====================================================
  // Create Reactive Form
  // =====================================================

  ngOnInit(): void {

    this.enrollForm = this.fb.group({

      // Student Name
      studentName: [
        '',
        [
          Validators.required,
          Validators.minLength(3)
        ]
      ],


      // Student Email
      // Includes synchronous and asynchronous validators
      studentEmail: this.fb.control(

        '',

        [
          Validators.required,
          Validators.email
        ],

        [
          simulateEmailCheck
        ]

      ),


      // Course ID
      // Includes custom noCourseCode validator
      courseId: [

        null,

        [
          Validators.required,
          noCourseCode
        ]

      ],


      // Preferred Semester
      preferredSemester: [

        'Odd',

        Validators.required

      ],


      // Terms and Conditions
      // Must be checked
      agreeToTerms: [

        false,

        Validators.requiredTrue

      ],


      // Dynamic FormArray
      additionalCourses: this.fb.array([])

    });

  }


  // =====================================================
  // Typed FormArray Getter
  // =====================================================
  // This getter keeps the template clean.
  // Instead of repeatedly casting the control to FormArray
  // inside the HTML template, we access it using this getter.
  // =====================================================

  get additionalCourses(): FormArray<FormControl<string>> {

    return this.enrollForm.get(
      'additionalCourses'
    ) as FormArray<FormControl<string>>;

  }


  // =====================================================
  // Get Individual Course Control
  // =====================================================
  // Returns a FormControl instead of AbstractControl.
  // This fixes the TS2739 error when using [formControl]
  // in the HTML template.
  // =====================================================

  getCourseControl(
    index: number
  ): FormControl<string> {

    return this.additionalCourses.at(
      index
    ) as FormControl<string>;

  }


  // =====================================================
  // Add New Course
  // =====================================================

  addCourse(): void {

    const newCourse =
      new FormControl<string>(
        '',
        {
          nonNullable: true,
          validators: Validators.required
        }
      );

    this.additionalCourses.push(
      newCourse
    );

  }


  // =====================================================
  // Remove Course
  // =====================================================

  removeCourse(
    index: number
  ): void {

    this.additionalCourses.removeAt(
      index
    );

  }


  // =====================================================
  // Submit Form
  // =====================================================

  onSubmit(): void {

    console.log(
      'Form Value:',
      this.enrollForm.value
    );


    // form.value excludes disabled controls.
    // getRawValue() includes all controls,
    // including disabled controls.

    console.log(
      'Raw Form Value:',
      this.enrollForm.getRawValue()
    );

  }

}