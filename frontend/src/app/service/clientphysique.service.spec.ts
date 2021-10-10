import { TestBed } from '@angular/core/testing';

import { ClientphysiqueService } from './clientphysique.service';

describe('ClientphysiqueService', () => {
  let service: ClientphysiqueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClientphysiqueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
