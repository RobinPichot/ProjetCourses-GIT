import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PageRestaurantRechercheHttpService {


  
  constructor(private http: HttpClient){}

  
  charge(ville:string): Observable<Restaurant>{
    return this.http.get<Restaurant>("http://localhost:8888/restaurants/recherche/" + ville );
  }
  
}