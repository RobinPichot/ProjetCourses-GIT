import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Commande, Restaurant } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PageRestaurantRechercheHttpService {
  serviceUrl : string;
  commande : Array<Commande>= new Array<Commande>();


  constructor(private http: HttpClient,private router: Router,private appConfig: AppConfigService){}

  
  charge(ville:string): Observable<Array<Restaurant>>{
    return this.http.get<Array<Restaurant>>("http://localhost:8888/restaurants/recherche/" + ville );
  }

 
  private load(): void {
    this.http.get<Array<Commande>>(this.serviceUrl).subscribe(response => {
      this.commande = response;
    });
}

  
}
