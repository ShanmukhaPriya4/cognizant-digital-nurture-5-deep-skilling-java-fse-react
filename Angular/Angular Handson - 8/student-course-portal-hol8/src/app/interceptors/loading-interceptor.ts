import { inject } from '@angular/core';

import {
  HttpInterceptorFn
} from '@angular/common/http';

import {
  finalize
} from 'rxjs';

import { LoadingService } from '../services/loading';

export const loadingInterceptor: HttpInterceptorFn =
  (req, next) => {

    const loadingService =
      inject(LoadingService);

    // Show loading spinner before HTTP request.
    loadingService.show();

    return next(req).pipe(

      // finalize executes whether the request
      // succeeds or fails.
      //
      // Therefore, it is the correct place
      // to hide the loading spinner.
      finalize(() => {

        loadingService.hide();

      })

    );

  };