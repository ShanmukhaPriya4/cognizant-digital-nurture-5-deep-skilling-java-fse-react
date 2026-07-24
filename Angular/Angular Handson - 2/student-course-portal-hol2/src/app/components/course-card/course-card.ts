import {
  Component,
  Input,
  OnChanges,
  SimpleChanges,
  Output,
  EventEmitter
} from '@angular/core';

@Component({
  selector: 'app-course-card',
  imports: [],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css',
})
export class CourseCard implements OnChanges {

  @Input() course: {
    id: number;
    name: string;
    code: string;
    credits: number;
  } = {
    id: 0,
    name: '',
    code: '',
    credits: 0
  };

  @Output() enrollRequested = new EventEmitter<number>();

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log(
        'Course changed:',
        'Previous value:',
        changes['course'].previousValue,
        'Current value:',
        changes['course'].currentValue
      );
    }
  }

  onEnroll(): void {
    this.enrollRequested.emit(this.course.id);
  }
}