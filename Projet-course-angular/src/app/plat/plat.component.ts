import { Component } from '@angular/core';
import { AccesCommandesComponent } from '../acces-commandes/acces-commandes.component';
import { Plat } from '../model';
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

  constructor(private platService: PlatHttpService, private variableG : VariableCompteConnecte) {
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
      this.platService.update(this.formPlat);
    } else { // CREATE
      this.platService.create(this.formPlat);
    }

    this.cancel();
  }

  cancel(): void {
    this.formPlat = null;
  }

  remove(id: number): void {
    this.platService.remove(id);
  }

  ngOnInit () {
    // this.restaurateurService.findById(this.variableGlobale.idConnecte).subscribe(result => {this.formRestaurateur= result});
    this.platService.findPlatById(this.variableG.idplatrestau).subscribe(result => {this.formPlats= result});
    // this.listRestaurant();
  }
}
