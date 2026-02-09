import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaAutoescuelas } from './lista-autoescuelas';

describe('ListaAutoescuelas', () => {
  let component: ListaAutoescuelas;
  let fixture: ComponentFixture<ListaAutoescuelas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaAutoescuelas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaAutoescuelas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
