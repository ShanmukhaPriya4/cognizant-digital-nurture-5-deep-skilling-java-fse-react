import { Component, Input } from '@angular/core';
import { NgSwitch, NgSwitchCase, NgSwitchDefault, NgClass, NgStyle } from '@angular/common';
import { Highlight } from '../directives/highlight';
import { CreditLabelPipe } from '../pipes/credit-label-pipe.spec';
@Component({
  selector: 'app-course-card',
  imports: [
    NgSwitch,
    NgSwitchCase,
    NgSwitchDefault,
    NgClass,
    NgStyle,
    Highlight,
    CreditLabelPipe
  ],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard {

  @Input() course: any;

  // Tracks whether the course details are expanded.
  isExpanded = false;

  // Tracks whether the student has enrolled in the course.
  isEnrolled = false;

  // Getter keeps the template clean by moving conditional
  // ngClass logic into the component class.
  get cardClasses() {
    return {
      'card--enrolled': this.isEnrolled,
      'card--full': this.course?.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  enroll(): void {
    this.isEnrolled = true;
  }

  getGradeColor(): string {
    switch (this.course?.gradeStatus) {
      case 'passed':
        return 'green';

      case 'failed':
        return 'red';

      default:
        return 'grey';
    }
  }
}