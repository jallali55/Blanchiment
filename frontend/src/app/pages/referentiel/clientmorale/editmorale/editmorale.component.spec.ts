import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditmoraleComponent } from './editmorale.component';

describe('EditmoraleComponent', () => {
  let component: EditmoraleComponent;
  let fixture: ComponentFixture<EditmoraleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditmoraleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditmoraleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
