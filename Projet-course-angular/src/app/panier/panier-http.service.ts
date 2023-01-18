import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Commande, Panier } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PanierHttpService {

  serviceUrl: string;
  paniers:Array<Panier>=new Array<Panier>();
  
  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "commandes/panier/";
    this.load();
   }

   findAll(): Array<Panier> {
    return this.paniers;
  }
  
  findPanierByIdCommandeByIdClient(id : number){
   return this.http.get<Array<Panier>>(this.serviceUrl +"client/"+ id);
  }

  findCommandeById(id : number){
    return this.http.get<Commande>(this.serviceUrl+"paye/"+id)
  }
  private load(): void {
    this.http.get<Array<Panier>>(this.serviceUrl).subscribe(response => {
      this.paniers = response;
    });
}
}
