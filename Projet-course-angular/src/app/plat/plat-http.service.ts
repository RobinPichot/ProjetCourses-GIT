import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Plat } from '../model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlatHttpService {
  serviceUrl: string;
  plats: Array<Plat> = new Array<Plat>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "plats/";
    this.load();
   }

   findAll(): Array<Plat> {
    return this.plats;
  }

  findById(id: number): Observable<Plat> {
    return this.http.get<Plat>(this.serviceUrl + id);
  }

  create(plat: Plat): Observable <boolean> {
    return new Observable((observer)=>{ this.http.post<Plat>(this.serviceUrl, plat).subscribe(resp => {
      this.load();
      observer.next(true);
    })
    
    });

  }

  update(matiere: Plat): void {
    this.http.put<Plat>(this.serviceUrl + matiere.id, matiere).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
      this.load();
    });
  }


  findPlatById(id: number): Observable<Array<Plat>> {
    return this.http.get<Array<Plat>>(this.serviceUrl + id + "/with-restau");
  }

  private load(): void {
    this.http.get<Array<Plat>>(this.serviceUrl).subscribe(response => {
      this.plats = response;
    });
  }
}
