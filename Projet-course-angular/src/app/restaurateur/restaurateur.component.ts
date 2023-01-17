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

  


  constructor(private restaurateurService: RestaurateurHttpService, private restaurantService: RestaurantHttpService, private variableGlobale : VariableCompteConnecte ) {
  }

  listRestaurateur(): Array<Restaurateur> {
    return this.restaurateurService.findAll();
  }

  listRestaurant(): Array<Restaurant> {
    
    return this.restaurantService.findAll();

  }

  ngOnInit () {
    this.restaurateurService.findById(this.variableGlobale.idConnecte).subscribe(result => {this.formRestaurateur= result});
  }

}
