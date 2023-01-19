import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-acces-commandes',
  templateUrl: './acces-commandes.component.html',
  styleUrls: ['./acces-commandes.component.scss']
})
export class AccesCommandesComponent {

  constructor(private router:Router){

  }

  renvoiPagedeConnexion(){
    this.router.navigate([""]);
  }

}
