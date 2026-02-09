import { TestBed } from '@angular/core/testing';

import { Autoescuela } from './autoescuela.service';

describe('Autoescuela', () => {
  let service: Autoescuela;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Autoescuela);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
