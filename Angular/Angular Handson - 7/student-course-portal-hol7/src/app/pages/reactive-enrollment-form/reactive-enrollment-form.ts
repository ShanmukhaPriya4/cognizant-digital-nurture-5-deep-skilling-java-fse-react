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

// Custom synchronous validator
// Rejects course IDs that start with "XX"
function noCourseCode(
  control: AbstractControl
): ValidationErrors | null {

  const value = control.value;

  if (value && value.toString().startsWith('XX')) {
    return {
      noCourseCode: true
    };
  }

  return null;
}

// Custom asynchronous validator
// Simulates checking whether an email is already taken
function simulateEmailCheck(
  control: AbstractControl
): Promise<ValidationErrors | null> {

  return new Promise((resolve) => {

    setTimeout(() => {

      const email = control.value;

      if (email && email.includes('test@')) {
        resolve({
          emailTaken: true
        });
      } else {
        resolve(null);
      }

    }, 800);

  });
}

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
export class ReactiveEnrollmentForm implements OnInit {

  enrollForm!: FormGroup;

  constructor(
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {

    this.enrollForm = this.fb.group({

      studentName: [
        '',
        [
          Validators.required,
          Validators.minLength(3)
        ]
      ],

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

      courseId: [
        null,
        [
          Validators.required,
          noCourseCode
        ]
      ],

      preferredSemester: [
        'Odd',
        Validators.required
      ],

      agreeToTerms: [
        false,
        Validators.requiredTrue
      ],

      additionalCourses: this.fb.array([])

    });

  }

  // Getter for the FormArray.
  // This keeps the template clean and avoids
  // repeatedly casting the control to FormArray.
  get additionalCourses(): FormArray {
    return this.enrollForm.get(
      'additionalCourses'
    ) as FormArray;
  }

  // Add a new course input
  addCourse(): void {

    this.additionalCourses.push(
      new FormControl(
        '',
        Validators.required
      )
    );

  }

  // Remove a course input
  removeCourse(index: number): void {

    this.additionalCourses.removeAt(index);

  }

  // Submit the form
  onSubmit(): void {

    console.log(
      'Form Value:',
      this.enrollForm.value
    );

    // value excludes disabled controls.
    // getRawValue() includes disabled controls.
    console.log(
      'Raw Form Value:',
      this.enrollForm.getRawValue()
    );

  }

  // CanDeactivate Guard method
  // Allows navigation if the form is unchanged.
  // Shows a confirmation dialog if the form has unsaved changes.
  canDeactivate(): boolean {

    if (!this.enrollForm.dirty) {
      return true;
    }

    return window.confirm(
      'You have unsaved changes. Leave?'
    );

  }

}