import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientphysiqueComponent } from './clientphysique.component';

describe('ClientphysiqueComponent', () => {
  let component: ClientphysiqueComponent;
  let fixture: ComponentFixture<ClientphysiqueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientphysiqueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientphysiqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
