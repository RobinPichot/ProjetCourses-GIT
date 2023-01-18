import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Restaurant } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';
import { PageRestaurantRechercheHttpService } from './page-restaurant-recherche-http.service';

@Component({
  selector: 'app-client-restaurant-recherche',
  templateUrl: './client-restaurant-recherche.component.html',
  styleUrls: ['./client-restaurant-recherche.component.scss']
})
export class ClientRestaurantRechercheComponent  implements OnInit{
 ville:string;
  restaurants : Array<Restaurant>;
  constructor(private variableGlobale : VariableCompteConnecte,private http: PageRestaurantRechercheHttpService,
    private router: Router,){}
 
  ngOnInit() {


    console.log(this.variableGlobale.villeRecherche)
    console.log(this.variableGlobale.idConnecte)
    console.log(this.variableGlobale.loginConnecte)
    this.recherche();
  }

  recherche(){
    this.http.charge(this.variableGlobale.villeRecherche).subscribe(
      (result) => { this.restaurants=result;
        console.log(this.restaurants)
        this.ville=this.variableGlobale.villeRecherche;
  });

}
}