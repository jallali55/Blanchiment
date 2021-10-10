import { TestBed } from '@angular/core/testing';

import { ListenoireService } from './listenoire.service';

describe('ListenoireService', () => {
  let service: ListenoireService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListenoireService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
