import { TestBed } from '@angular/core/testing';

import { CinemaseatService } from './cinemaseat.service';

describe('CinemaseatService', () => {
  let service: CinemaseatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CinemaseatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
