import { Component } from '@angular/core';

import { AsyncPipe } from '@angular/common';

import { LoadingService }
  from './services/loading';

@Component({
  selector: 'app-root',

  imports: [
    AsyncPipe
  ],

  templateUrl: './app.html',

  styleUrl: './app.css'
})
export class App {

  constructor(
    public loadingService: LoadingService
  ) {}

}