import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Commande, Panier, Restaurant } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PageRestaurantRechercheHttpService {
  serviceUrl : string;
  commande : Array<Commande>= new Array<Commande>();
paniers: Array<Panier>;

  constructor(private http: HttpClient,private router: Router,private appConfig: AppConfigService){}

  
  charge(ville:string): Observable<Array<Restaurant>>{
    return this.http.get<Array<Restaurant>>("http://localhost:8888/restaurants/recherche/" + ville );
  }

 
  private load(): void {
    this.http.get<Array<Commande>>(this.serviceUrl).subscribe(response => {
      this.commande = response;
    });
}


remove(id:number):void{
  this.http.delete<void>("http://localhost:8888/commandes/delete/"+ id).subscribe(resp => {
   this.load1();
 });
}
private load1(): void {
  this.http.get<Array<Panier>>("http://localhost:8888/commandes").subscribe(response => {
    this.paniers = response;
  });
}
  
}
