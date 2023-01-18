import { Injectable } from '@angular/core';
import { Commande, Compte } from '../model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConnexionHttpService {

  commande : Commande;
  constructor(private http: HttpClient) { 
  }

  login(login: string,password: string): Observable<Compte>{
    return this.http.get<Compte>("http://localhost:8888/comptes/connexion/" + login + "/" + password);
  }

  findCommandeById(id : number){
    return this.http.get<Commande>("http://localhost:8888/commandes/all/"+id)
  }

}


