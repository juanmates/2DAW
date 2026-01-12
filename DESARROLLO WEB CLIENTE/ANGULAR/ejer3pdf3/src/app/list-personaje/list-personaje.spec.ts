import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPersonaje } from './list-personaje';

describe('ListPersonaje', () => {
  let component: ListPersonaje;
  let fixture: ComponentFixture<ListPersonaje>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListPersonaje]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListPersonaje);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
