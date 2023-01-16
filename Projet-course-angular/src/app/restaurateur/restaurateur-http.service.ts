import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Restaurateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class RestaurateurHttpService {
  serviceUrl: string;
  restaurateurs: Array<Restaurateur> = new Array<Restaurateur>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "Comptes/";
    this.load();
   }

   findAll(): Array<Restaurateur> {
    return this.restaurateurs;
  }
  
  findById(id: number): Observable<Restaurateur> {
    return this.http.get<Restaurateur>(this.serviceUrl + id);
  }

  create(restaurateur: Restaurateur): void {
    this.http.post<Restaurateur>(this.serviceUrl, restaurateur).subscribe(resp => {
      this.load();
    });
  }

  update(restaurateur: Restaurateur): void {
    this.http.put<Restaurateur>(this.serviceUrl + restaurateur.id, restaurateur).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Restaurateur>>(this.serviceUrl).subscribe(response => {
      this.restaurateurs = response;
    });
}
}
