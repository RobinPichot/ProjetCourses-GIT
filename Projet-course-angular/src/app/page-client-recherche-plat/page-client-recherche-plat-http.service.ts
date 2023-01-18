import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Plat } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';

@Injectable({
  providedIn: 'root'
})
export class PageClientRecherchePlatHttpService {

  constructor(private http: HttpClient,private router: Router,private variableGlobale : VariableCompteConnecte){}

  
  chargePlats(): Observable<Array<Plat>>{
    return this.http.get<Array<Plat>>("http://localhost:8888/plats/"+this.variableGlobale.idRestaurantRechercheParClient+"with-restau");
  }

}
