import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatosLibro } from './datos-libro';

describe('DatosLibro', () => {
  let component: DatosLibro;
  let fixture: ComponentFixture<DatosLibro>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DatosLibro]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DatosLibro);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
