import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChargerFichierComponent } from './charger-fichier.component';

describe('ChargerFichierComponent', () => {
  let component: ChargerFichierComponent;
  let fixture: ComponentFixture<ChargerFichierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChargerFichierComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChargerFichierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
