import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Commande } from '../model';

@Injectable({
  providedIn: 'root'
})
export class NouvelleCommandeHttpService {

  serviceUrl: string;
  commandes:Array<Commande> = new Array<Commande>();



  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "commandes/";
    this.load();
   }

  findAllNonLivreesEtSansLivreur(): Observable<Array<Commande>> {
    return this.http.get<Array<Commande>>(this.serviceUrl+"sansLivreur/nonLivrees");
  }

  findNonLivreeByLivreur(id:number): Observable<Array<Commande>> {
    return this.http.get<Array<Commande>>(this.serviceUrl+"livreur/"+id+"/nonLivree");
  }

  update(idCompte:number, idNouveauLivreur:number): void {
    this.http.put<Commande>(this.serviceUrl+idCompte+"/changer-livreur/"+idNouveauLivreur,idCompte).subscribe(resp => {
      this.load();
    });
  }

  updateStatutLivraison(idCompte:number): void {
    this.http.put<Commande>(this.serviceUrl+idCompte+"/confirmer-livraison",idCompte).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Commande>>(this.serviceUrl).subscribe(response => {
      this.commandes = response;
    });
  }
  
}

