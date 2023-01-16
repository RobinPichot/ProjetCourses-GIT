import { Component } from '@angular/core';
import { Restaurant, Restaurateur } from '../model';
import { RestaurantHttpService } from '../restaurant/restaurant-http.service';
import { RestaurateurHttpService } from './restaurateur-http.service';

@Component({
  selector: 'app-restaurateur',
  templateUrl: './restaurateur.component.html',
  styleUrls: ['./restaurateur.component.scss']
})
export class RestaurateurComponent {

  formRestaurateur: Restaurateur = null;

  constructor(private restaurateurService: RestaurateurHttpService, private restaurantService: RestaurantHttpService ) {
  }

  listRestaurateur(): Array<Restaurateur> {
    return this.restaurateurService.findAll();
  }

  listRestaurant(): Array<Restaurant> {
    return this.restaurantService.findAll();
  }


}
