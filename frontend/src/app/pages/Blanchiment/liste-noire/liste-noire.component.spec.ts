import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeNoireComponent } from './liste-noire.component';

describe('ListeNoireComponent', () => {
  let component: ListeNoireComponent;
  let fixture: ComponentFixture<ListeNoireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeNoireComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeNoireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
