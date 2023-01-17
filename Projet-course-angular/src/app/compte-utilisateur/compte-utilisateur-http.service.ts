import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Client, Compte } from '../model';

@Injectable({
  providedIn: 'root'
})
export class CompteUtilisateurHttpService {

  
  serviceUrl: string;
  clients : Array<Client> = new Array<Client>();
  
  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.serviceUrl = appConfig.backEndUrl + "comptes/";
    this.load();
  }

  findAll(): Array<Client> {
    return this.clients;
  }

  findByLogin(login : string){
    return this.http.get<Client>(this.serviceUrl + login)
  }

  findById(id: number): Observable<Client> {
    return this.http.get<Client>(this.serviceUrl +id);
  }
  
  create(client: Client): void {
    this.http.post<Client>(this.serviceUrl, client).subscribe(resp => {
      this.load();
    });
  }

  update(client: Client): Observable<Client> {

    // return this.http.put<Client>(this.serviceUrl +"client/"+client.id, client);

    return new Observable<Client>((observer) => {
      this.http.put<Client>(this.serviceUrl +"client/"+client.id, client).subscribe(resp => {
        observer.next(resp);
      });
    });
  }

  private load(): void {
    this.http.get<Array<Client>>(this.serviceUrl).subscribe(response => {
      this.clients = response;
    });
  }
}
