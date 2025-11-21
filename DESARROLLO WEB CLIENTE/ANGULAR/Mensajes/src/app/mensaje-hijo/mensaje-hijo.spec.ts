import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MensajeHijo } from './mensaje-hijo';

describe('MensajeHijo', () => {
  let component: MensajeHijo;
  let fixture: ComponentFixture<MensajeHijo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MensajeHijo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MensajeHijo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
