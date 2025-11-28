import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoArticulo } from './listado-articulo';

describe('ListadoArticulo', () => {
  let component: ListadoArticulo;
  let fixture: ComponentFixture<ListadoArticulo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListadoArticulo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListadoArticulo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
