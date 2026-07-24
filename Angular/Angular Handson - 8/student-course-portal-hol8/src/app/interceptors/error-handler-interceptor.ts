import {
  HttpErrorResponse,
  HttpInterceptorFn
} from '@angular/common/http';

import {
  catchError,
  throwError
} from 'rxjs';

import { Router } from '@angular/router';

export const errorHandlerInterceptor: HttpInterceptorFn =
  (req, next) => {

    const router = inject(Router);

    return next(req).pipe(

      catchError(
        (error: HttpErrorResponse) => {

          console.error(
            'HTTP Error:',
            error
          );

          // Handle Unauthorized error
          if (error.status === 401) {

            console.error(
              'Unauthorized. Redirecting to home.'
            );

            router.navigate(['/']);

          }

          // Handle Server error
          else if (error.status === 500) {

            console.error(
              'Internal Server Error.'
            );

            alert(
              'Server error occurred. Please try again later.'
            );

          }

          return throwError(
            () => error
          );

        }
      )

    );

  };
