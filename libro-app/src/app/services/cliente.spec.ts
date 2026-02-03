import { TestBed } from '@angular/core/testing';

import { ClienteServise } from './cliente';

describe('ClienteService', () => {
  let service: ClienteServise;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClienteServise);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
