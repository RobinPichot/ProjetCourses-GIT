import { TestBed } from '@angular/core/testing';

import { CommandeRestauHttpService } from './commande-restau-http.service';

describe('CommandeRestauHttpService', () => {
  let service: CommandeRestauHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommandeRestauHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
