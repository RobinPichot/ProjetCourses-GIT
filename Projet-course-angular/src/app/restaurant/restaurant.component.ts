import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Plat, Restaurant } from '../model';
import { PlatHttpService } from '../plat/plat-http.service';
import { VariableCompteConnecte } from '../VariableGlobale';
import { RestaurantHttpService } from './restaurant-http.service';
import { OnInit } from '@angular/core';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.scss']
})
export class RestaurantComponent {

  formRestaur: Restaurant = null;
  formPlat: Array<Plat> = new Array <Plat>();

  constructor(private restaurantService: RestaurantHttpService, private variableGlobale : VariableCompteConnecte, private platservice: PlatHttpService) {
  }

  // listPlat(): Array<Plat> {
  //   return this.platservice.findPlatById(this.formRestaurant.id);
  // }

  ngOnInit () {
    this.restaurantService.findById(this.variableGlobale.idplatrestau).subscribe(result => {this.formRestaur= result});
    // this.restaurateurService.findById(this.variableGlobale.idConnecte).subscribe(result => {this.formRestaurateur= result});
    this.platservice.findPlatById(this.variableGlobale.idplatrestau).subscribe(result => {this.formPlat= result; console.log(this.formPlat)});
    // this.listRestaurant();
  }
  
}
