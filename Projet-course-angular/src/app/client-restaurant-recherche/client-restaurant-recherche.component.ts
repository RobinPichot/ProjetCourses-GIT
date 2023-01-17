import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';

@Component({
  selector: 'app-client-restaurant-recherche',
  templateUrl: './client-restaurant-recherche.component.html',
  styleUrls: ['./client-restaurant-recherche.component.scss']
})
export class ClientRestaurantRechercheComponent  implements OnInit{
 
  constructor(private variableGlobale : VariableCompteConnecte){}
 
 
  ngOnInit(): void {
    console.log(this.variableGlobale.villeRecherche)
    console.log(this.variableGlobale.idConnecte)
    console.log(this.variableGlobale.loginConnecte)

  }


}
