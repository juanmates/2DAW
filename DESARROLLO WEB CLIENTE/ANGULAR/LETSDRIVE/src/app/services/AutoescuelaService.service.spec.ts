/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { AutoescuelaServiceService } from './AutoescuelaService.service';

describe('Service: AutoescuelaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AutoescuelaServiceService]
    });
  });

  it('should ...', inject([AutoescuelaServiceService], (service: AutoescuelaServiceService) => {
    expect(service).toBeTruthy();
  }));
});
