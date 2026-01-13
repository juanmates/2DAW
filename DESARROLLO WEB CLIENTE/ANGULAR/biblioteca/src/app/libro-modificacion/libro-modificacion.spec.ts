import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibroModificacion } from './libro-modificacion';

describe('LibroModificacion', () => {
  let component: LibroModificacion;
  let fixture: ComponentFixture<LibroModificacion>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LibroModificacion]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibroModificacion);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
