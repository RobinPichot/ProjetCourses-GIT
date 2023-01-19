import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';

import { Commande, Compte, FormCompte, Restaurant } from '../model';


@Injectable({
  providedIn: 'root'
})
export class HistoriqueCommandesHttpService {

  serviceUrl: string;
  commandes:Array<Commande> = new Array<Commande>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl;
    this.load();
   }

  findLivreeByLivreur(id: number): Observable<Array<Commande>> {
    return this.http.get<Array<Commande>>(this.serviceUrl + "commandes/livreur/"+id+ "/livree");
  }

  findAllRestaurants(): Observable<Array<Restaurant>> {
    return this.http.get<Array<Restaurant>>(this.serviceUrl+"restaurants/");
  }

  findAllComptes(): Observable<Array<Compte>> {
    return this.http.get<Array<Compte>>(this.serviceUrl+"comptes/");
  }

  private load(): void {
    this.http.get<Array<Commande>>(this.serviceUrl+ "commandes/").subscribe(response => {
      this.commandes = response;
    });
  }
}
