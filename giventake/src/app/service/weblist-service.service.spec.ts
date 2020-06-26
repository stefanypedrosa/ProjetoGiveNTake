import { TestBed } from '@angular/core/testing';

import { WeblistServiceService } from './weblist-service.service';

describe('WeblistServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WeblistServiceService = TestBed.get(WeblistServiceService);
    expect(service).toBeTruthy();
  });
});
