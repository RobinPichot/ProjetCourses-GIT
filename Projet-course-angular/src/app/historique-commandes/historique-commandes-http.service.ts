import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';

import { Commande, Compte, FormCompte } from '../model';


@Injectable({
  providedIn: 'root'
})
export class HistoriqueCommandesHttpService {

  serviceUrl: string;
  commandes:Array<Commande> = new Array<Commande>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "commandes/";
    this.load();
   }

  findLivreeByLivreur(id: number): Observable<Array<Commande>> {
    return this.http.get<Array<Commande>>(this.serviceUrl+"livreur/"+id+ "/livree");
  }

  private load(): void {
    this.http.get<Array<Commande>>(this.serviceUrl).subscribe(response => {
      this.commandes = response;
    });
  }
}
