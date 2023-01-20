import { Component } from '@angular/core';
import { AccesCommandesComponent } from '../acces-commandes/acces-commandes.component';
import { Plat, Restaurant } from '../model';
import { RestaurantHttpService } from '../restaurant/restaurant-http.service';
import { VariableCompteConnecte } from '../VariableGlobale';
import { PlatHttpService } from './plat-http.service';

@Component({
  selector: 'app-plat',
  templateUrl: './plat.component.html',
  styleUrls: ['./plat.component.scss']
})
export class PlatComponent {

  formPlat:  Plat;
  formPlats: Array<Plat> = new Array<Plat>();
  formrestau2:  Restaurant;

  constructor(private platService: PlatHttpService, private variableG : VariableCompteConnecte, private restaurantService: RestaurantHttpService) {
  }

  // listPlat(): Array<Plat> {
  //   return this.platService.findPlatById(this.variableG.idplatrestau);
  // }

  add():void {
    this.formPlat = new Plat();
  }

  edit(id: number): void {
    this.platService.findById(id).subscribe(resp => {
      this.formPlat = resp;
    });
  }

  save(): void {
    
    if(this.formPlat.id) { // UPDATE
      this.formPlat.restaurant =this.formrestau2;
      this.platService.update(this.formPlat).subscribe(result => this.platService.findPlatById(this.variableG.idplatrestau).subscribe(result => {this.formPlats= result})
      );
    } else { // CREATE
      this.formPlat.restaurant =this.formrestau2;
      this.platService.create(this.formPlat).subscribe(result => this.platService.findPlatById(this.variableG.idplatrestau).subscribe(result => {this.formPlats= result})
      );
    }

    this.cancel();
  }

  cancel(): void {
    this.formPlat = null;
  }

  remove(id: number): void {
    this.platService.remove(id).subscribe(result => this.platService.findPlatById(this.variableG.idplatrestau).subscribe(result => {this.formPlats= result}));
  }

  ngOnInit () {
    // this.restaurateurService.findById(this.variableGlobale.idConnecte).subscribe(result => {this.formRestaurateur= result});
    this.platService.findPlatById(this.variableG.idplatrestau).subscribe(result => {this.formPlats= result});
  
      this.restaurantService.findById(this.variableG.idplatrestau).subscribe(result => {this.formrestau2= result});
      // this.restaurateurService.findById(this.variableGlobale.idConnecte).subscribe(result => {this.formRestaurateur= result});
      // this.platservice.findPlatById(this.variableGlobale.idplatrestau).subscribe(result => {this.formPlat= result});
      // this.listRestaurant();
    
  }
}
