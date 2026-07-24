import { CanDeactivateFn } from '@angular/router';

export interface CanComponentDeactivate {
  canDeactivate: () => boolean;
}

export const unsavedChangesGuard: CanDeactivateFn<CanComponentDeactivate> = (
  component
) => {

  // If the form is not dirty, allow navigation
  if (!component.canDeactivate) {
    return true;
  }

  return component.canDeactivate();
};