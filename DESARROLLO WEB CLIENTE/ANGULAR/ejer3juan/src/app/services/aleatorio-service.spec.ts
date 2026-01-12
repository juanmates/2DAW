import { TestBed } from '@angular/core/testing';

import { AleatorioService } from './aleatorio-service';

describe('AleatorioService', () => {
  let service: AleatorioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AleatorioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
