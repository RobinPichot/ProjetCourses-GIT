import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Commande } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ClientAttenteHttpService {

  commandes : Array<Commande>=new Array<Commande>
  serviceUrl:string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.serviceUrl = appConfig.backEndUrl + "commandes/attente/";
    this.load();
  }

findCommandeById(id : number){
    return this.http.get<Commande>(this.serviceUrl+"paye/"+id)
  }

  private load(): void {
    this.http.get<Array<Commande>>(this.serviceUrl).subscribe(response => {
      this.commandes = response;
    });
}
}
