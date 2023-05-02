import { TestBed } from '@angular/core/testing';

import { AddquesService } from './addques.service';

describe('AddquesService', () => {
  let service: AddquesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddquesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
