import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Compte } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';

@Component({
  selector: 'app-acces-commandes',
  templateUrl: './acces-commandes.component.html',
  styleUrls: ['./acces-commandes.component.scss']
})
export class AccesCommandesComponent {

  constructor(private router:Router, public variableGlobal: VariableCompteConnecte) {
  }

  renvoiPagedeConnexion(){
    this.router.navigate([""]);
  }

  renvoiPageLivreur(){
    this.router.navigate(['/livreur']);
  }

  renvoiHistorique(){
    this.router.navigate(['/livreur/historique']);
  }

  renvoiCommandesEnCours(){
    this.router.navigate(['/livreur/nouvelle_commande']);
  }

}
