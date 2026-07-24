import { Component } from '@angular/core';
import { NotificationService } from '../../services/notification';

@Component({
  selector: 'app-notification',
  imports: [],
  templateUrl: './notification.html',
  styleUrl: './notification.css',

  // Component-level provider:
  // This creates a new NotificationService instance
  // scoped only to this component and its children.
  providers: [NotificationService]
})
export class Notification {

}