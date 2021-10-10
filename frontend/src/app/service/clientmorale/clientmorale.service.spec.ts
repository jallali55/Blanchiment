import { TestBed } from '@angular/core/testing';

import { ClientmoraleService } from './clientmorale.service';

describe('ClientmoraleService', () => {
  let service: ClientmoraleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClientmoraleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
