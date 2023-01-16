import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';

import { Commande, Compte, FormCompte } from '../model';


@Injectable({
  providedIn: 'root'
})
export class AccesCommandesHttpService {

  serviceUrl: string;

  commandes:Array<Commande> = new Array<Commande>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "commandes/";
    this.load();
   }

  // create(compte: Compte): void {
  //   this.http.post<Compte>(this.serviceUrl, Compte).subscribe(resp => {
  //     this.load();
  //   });
  // }

  findAllNonLivreesEtSansLivreur(): void {
    this.http.get<Array<Commande>>(this.serviceUrl+ "commandes/" + "sansLivreur/nonLivrees").subscribe(resp => {
      this.load();
    });


  }

  private load(): void {
    this.http.get<Array<Commande>>(this.serviceUrl).subscribe(response => {
      this.commandes = response;
    });
  }
}
