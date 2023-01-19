import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Commande } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ClientPageRechercheHttpService {

  serviceUrl : string;
  commande : Array<Commande>= new Array<Commande>();
  
  constructor(private http: HttpClient,
              private appConfig: AppConfigService) { }

  create(id : number): void {
    this.http.post<Commande>("http://localhost:8888/commandes/"+id, id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Commande>>(this.serviceUrl).subscribe(response => {
      this.commande = response;
    });
}
}