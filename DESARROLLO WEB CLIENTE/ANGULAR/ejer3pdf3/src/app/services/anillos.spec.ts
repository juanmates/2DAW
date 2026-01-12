import { TestBed } from '@angular/core/testing';

import { Anillos } from './anillos';

describe('Anillos', () => {
  let service: Anillos;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Anillos);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
