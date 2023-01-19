import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Panier, Plat } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';

@Injectable({
  providedIn: 'root'
})
export class PageClientRecherchePlatHttpService {
paniers: Array<Panier>;
  constructor(private http: HttpClient,private router: Router,private variableGlobale : VariableCompteConnecte){}

  
  chargePlats(): Observable<Array<Plat>>{
    return this.http.get<Array<Plat>>("http://localhost:8888/plats/"+this.variableGlobale.idRestaurantRechercheParClient+"/with-restau");
  }

  ajoutPanier(idCom:number,idPlat:number,qte:number): void {
    this.http.post<Panier>("http://localhost:8888/paniers/create/"+idCom+"/"+idPlat+"/"+qte, {idCom,idPlat,qte}).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Panier>>("http://localhost:8888/paniers").subscribe(response => {
      this.paniers = response;
    });
}

}
