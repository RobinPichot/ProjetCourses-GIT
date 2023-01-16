import { Injectable } from '@angular/core';
import { Compte } from '../model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConnexionHttpService {

  
  constructor(private http: HttpClient) { 
  }

  login(login: string,password: string): Observable<Compte>{
    return this.http.get<Compte>("http://localhost:8888/comptes/connexion/" + login + "/" + password);
  }






}


