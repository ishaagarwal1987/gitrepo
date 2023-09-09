import { TestBed } from '@angular/core/testing';

import { ChequebookrequestService } from './chequebookrequest.service';

describe('ChequebookrequestService', () => {
  let service: ChequebookrequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChequebookrequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
