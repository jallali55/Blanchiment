import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewagenceComponent } from './newagence.component';

describe('NewagenceComponent', () => {
  let component: NewagenceComponent;
  let fixture: ComponentFixture<NewagenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewagenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewagenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
