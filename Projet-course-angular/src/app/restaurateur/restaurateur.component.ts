import { Component } from '@angular/core';
import { Restaurant, Restaurateur } from '../model';
import { RestaurantHttpService } from '../restaurant/restaurant-http.service';
import { RestaurateurHttpService } from './restaurateur-http.service';
import { VariableCompteConnecte } from '../VariableGlobale';
import { Observable } from 'rxjs';
import { OnInit } from '@angular/core';

@Component({
  selector: 'app-restaurateur',
  templateUrl: './restaurateur.component.html',
  styleUrls: ['./restaurateur.component.scss']
})
export class RestaurateurComponent implements OnInit {

  formRestaurateur: Restaurateur = null;

  formRestaurant: Array <Restaurant> = new Array<Restaurant>();
  


  constructor(private restaurateurService: RestaurateurHttpService, private restaurantService: RestaurantHttpService, private variableGlobale : VariableCompteConnecte, private restaurantservice: RestaurantHttpService ) {
  }

  listRestaurateur(): Array<Restaurateur> {
    return this.restaurateurService.findAll();
  }

  // listRestaurant(): Observable<Array<Restaurant>> {
    
  //   return this.restaurantservice.findRestaurantById(this.variableGlobale.idConnecte);

  // }
  
  getRestau(id : number){
  this.variableGlobale.idplatrestau = id;
  alert(id);
  }

  
  ngOnInit () {
    this.restaurateurService.findById(this.variableGlobale.idConnecte).subscribe(result => {this.formRestaurateur= result});
    this.restaurantService.findRestaurantById(this.variableGlobale.idConnecte).subscribe(result => {this.formRestaurant= result});
    // this.listRestaurant();
  }

}
