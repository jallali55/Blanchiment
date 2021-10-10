import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewmoraleComponent } from './newmorale.component';

describe('NewmoraleComponent', () => {
  let component: NewmoraleComponent;
  let fixture: ComponentFixture<NewmoraleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewmoraleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewmoraleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
