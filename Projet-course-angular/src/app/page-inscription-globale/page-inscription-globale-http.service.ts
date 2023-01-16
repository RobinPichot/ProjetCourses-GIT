import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';

import { Compte, FormCompte } from '../model';


@Injectable({
  providedIn: 'root'
})
export class PageInscriptionGlobaleHttpService {

  serviceUrl: string;
  comptes:Array<Compte> = new Array<Compte>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "comptes";
    this.load();
   }

  // create(compte: Compte): void {
  //   this.http.post<Compte>(this.serviceUrl, Compte).subscribe(resp => {
  //     this.load();
  //   });
  // }

  createFromInscription(formulaireCompte: FormCompte): void {
    this.http.post<Compte>(this.serviceUrl, formulaireCompte).subscribe(resp => {
      this.load();
    });


  }

  private load(): void {
    this.http.get<Array<Compte>>(this.serviceUrl).subscribe(response => {
      this.comptes = response;
    });
  }
}
