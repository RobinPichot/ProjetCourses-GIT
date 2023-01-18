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

  findRestaurantById(id: number): Observable<Array<Restaurant>> {
    return this.http.get<Array<Restaurant>>(this.serviceUrl + id + "/with-restaurants");
  }

  private load(): void {
    this.http.get<Array<Restaurant>>(this.serviceUrl).subscribe(response => {
      this.restaurants = response;
    });
  }
}
