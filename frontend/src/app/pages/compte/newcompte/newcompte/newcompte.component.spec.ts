import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewcompteComponent } from './newcompte.component';

describe('NewcompteComponent', () => {
  let component: NewcompteComponent;
  let fixture: ComponentFixture<NewcompteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewcompteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewcompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
