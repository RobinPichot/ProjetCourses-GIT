import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { AppConfigService } from "../app-config.service";
import { Commande } from "../model";

@Injectable({
  providedIn: "root",
})
export class ClientPageRechercheHttpService {
  serviceUrl: string;
  commande: Array<Commande> = new Array<Commande>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {}

  create(id: number): Observable<boolean> {
    return new Observable((observer) => {
      this.http
        .post<Commande>("http://localhost:8888/commandes/" + id, id)
        .subscribe((resp) => {
          this.load();
          observer.next(true);
        });
    });
  }

  private load(): void {
    this.http.get<Array<Commande>>(this.serviceUrl).subscribe((response) => {
      this.commande = response;
    });
  }

  findCommandeById(id: number) {
    return this.http.get<Array<Commande>>(
      "http://localhost:8888/commandes/all/" + id
    );
  }
}
