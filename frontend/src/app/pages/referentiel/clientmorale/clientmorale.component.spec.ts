import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientmoraleComponent } from './clientmorale.component';

describe('ClientmoraleComponent', () => {
  let component: ClientmoraleComponent;
  let fixture: ComponentFixture<ClientmoraleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientmoraleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientmoraleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
