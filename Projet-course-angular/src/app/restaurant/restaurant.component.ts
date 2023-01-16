import { Component } from '@angular/core';
import { Restaurant } from '../model';
import { RestaurantHttpService } from './restaurant-http.service';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.scss']
})
export class RestaurantComponent {

  formRestaurant: Restaurant = null;
  

  constructor(private restaurantService: RestaurantHttpService) {
  }

  listRestau(): Array<Restaurant> {
    return this.restaurantService.findAll();
  }

}
