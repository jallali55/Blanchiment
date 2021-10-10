import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditphysiqueComponent } from './editphysique.component';

describe('EditphysiqueComponent', () => {
  let component: EditphysiqueComponent;
  let fixture: ComponentFixture<EditphysiqueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditphysiqueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditphysiqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
