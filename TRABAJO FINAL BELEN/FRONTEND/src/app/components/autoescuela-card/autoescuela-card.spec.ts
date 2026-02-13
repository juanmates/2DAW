import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoescuelaCard } from './autoescuela-card';

describe('AutoescuelaCard', () => {
  let component: AutoescuelaCard;
  let fixture: ComponentFixture<AutoescuelaCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AutoescuelaCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AutoescuelaCard);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
