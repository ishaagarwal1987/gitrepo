import { TestBed } from '@angular/core/testing';

import { FieldworkService } from './fieldwork.service';

describe('FieldworkService', () => {
  let service: FieldworkService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FieldworkService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
