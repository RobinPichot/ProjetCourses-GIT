import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Restaurant } from '../model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestaurantHttpService {
  serviceUrl: string;
  restaurants: Array<Restaurant> = new Array<Restaurant>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.serviceUrl = appConfig.backEndUrl + "restaurants/";
    this.load();
  }


  findAll(): Array<Restaurant> {
    return this.restaurants;
  }

  create(restaurant: Restaurant): Observable <boolean> {
    return new Observable((observer)=>{ this.http.post<Restaurant>(this.serviceUrl, restaurant).subscribe(resp => {
      this.load();
      observer.next(true);
    })
    
  });
  }

  update(matiere: Restaurant): Observable <boolean> {
    return new Observable((observer)=>{this.http.put<Restaurant>(this.serviceUrl + matiere.id, matiere).subscribe(resp => {
      this.load();
      observer.next(true);
    });
  });
}

  remove(id: number): Observable <boolean> {
    return new Observable((observer)=>{ this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
      this.load();
      observer.next(true);
    });
  });
  }


  findById(id: number): Observable<Restaurant> {
    return this.http.get<Restaurant>(this.serviceUrl + id);
  }


  findRestaurantById(id: number): Observable<Array<Restaurant>> {
    return this.http.get<Array<Restaurant>>(this.serviceUrl + id + "/with-restaurants");
  }

  private load(): void {
    this.http.get<Array<Restaurant>>(this.serviceUrl).subscribe(response => {
      this.restaurants = response;
    });
  }
}
