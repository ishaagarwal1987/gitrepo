import { TestBed } from '@angular/core/testing';

import { Feedback;Service } from './feedback;.service';

describe('Feedback;Service', () => {
  let service: Feedback;Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Feedback;Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
