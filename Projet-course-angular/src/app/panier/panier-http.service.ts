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
  commandes:Array<Commande>=new Array<Commande>();
  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "commandes/";
    this.load();
   }

   findAll(): Array<Panier> {
    return this.paniers;
  }
  
  findPanierByIdCommandeByIdClient(id : number){
   return this.http.get<Array<Panier>>(this.serviceUrl +"panier/client/"+ id);
  }

  remove(id:number):void{
     this.http.delete<void>(this.serviceUrl +"delete/"+ id).subscribe(resp => {
      this.load();
    });
  }

updateStatutPaye(id : number){
  this.http.put<Commande>(this.serviceUrl+ "panier/paye/"+id,id).subscribe(resp => {
    this.load();
  });
}

updateCommanderestau(id : number,idRestau:number){
  this.http.put<Commande>(this.serviceUrl+ "editIdRestau/"+id+"/"+idRestau,{id,idRestau}).subscribe(resp => {
    this.load1()});
}

  private load(): void {
    this.http.get<Array<Panier>>(this.serviceUrl).subscribe(response => {
      this.paniers = response;
    });
}
private load1(): void {
  this.http.get<Array<Commande>>(this.serviceUrl).subscribe(response => {
    this.commandes = response;
  });
}
}
