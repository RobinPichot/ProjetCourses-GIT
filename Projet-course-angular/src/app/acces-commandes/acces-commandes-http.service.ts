import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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

  findById(id: number): Observable<Commande> {
    return this.http.get<Commande>(this.serviceUrl + id);
  }


  findAllNonLivreesEtSansLivreur(): void {
    this.http.get<Array<Commande>>(this.serviceUrl+ "commandes/" + "sansLivreur/nonLivrees").subscribe(resp => {
      this.load();
    });


  }

  findByIdRestau(id: number): Observable<Array<Commande>> {
    return this.http.get<Array<Commande>>(this.serviceUrl + id + "/with-restau");
  }

  create(matiere: Commande): void {
    this.http.post<Commande>(this.serviceUrl, matiere).subscribe(resp => {
      this.load();
    });
  }

  update(matiere: Commande): void {
    this.http.put<Commande>(this.serviceUrl + matiere.id, matiere).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Commande>>(this.serviceUrl).subscribe(response => {
      this.commandes = response;
    });
  }
}
