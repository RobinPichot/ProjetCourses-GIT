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
  formRestau: Restaurant = null;
  formRestaurant: Array <Restaurant> = new Array<Restaurant>();
  


  constructor(private restaurateurService: RestaurateurHttpService, private restaurantService: RestaurantHttpService, private variableGlobale : VariableCompteConnecte, private restaurantservice: RestaurantHttpService ) {
  }

  listRestaurateur(): Array<Restaurateur> {
    return this.restaurateurService.findAll();
  }

  add():void {
    this.formRestau = new Restaurant();
  }

  // listRestaurant(): Observable<Array<Restaurant>> {
    
  //   return this.restaurantservice.findRestaurantById(this.variableGlobale.idConnecte);

  // }

  edit(id: number): void {
    this.restaurantService.findById(id).subscribe(resp => {
      this.formRestau = resp;
    });
  }
  
  save(): void {
    
    if(this.formRestau.id) { // UPDATE
      this.formRestau.ouvert = true;
      this.formRestau.notation = 0;
      this.formRestau.restaurateur = this.formRestaurateur;
      this.restaurantService.update(this.formRestau);
    } else { // CREATE
      this.formRestau.ouvert = true;
      this.formRestau.notation = 0;
      this.formRestau.restaurateur = this.formRestaurateur;
      this.restaurantService.create(this.formRestau).subscribe(result => this.restaurantService.findRestaurantById(this.variableGlobale.idConnecte).subscribe(result => {this.formRestaurant= result}))
     
    }

    this.cancel();
  }

  cancel(): void {
    this.formRestau = null;
  }

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
