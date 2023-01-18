import { Component, OnInit } from '@angular/core';
import { Commande } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';
import { ClientAttenteHttpService } from './client-attente-http.service';

@Component({
  selector: 'app-client-attente-liveur',
  templateUrl: './client-attente-liveur.component.html',
  styleUrls: ['./client-attente-liveur.component.scss']
})
export class ClientAttenteLiveurComponent implements OnInit {

commande : Commande;
constructor(private clientAttenteService : ClientAttenteHttpService,private variableGlobal : VariableCompteConnecte){
  setInterval(() => {
    this.statutlivreur();
  }, 5000);
}

ngOnInit(){
  this.statutlivreur();
}

statutlivreur(){
  this.clientAttenteService.findCommandeById(this.variableGlobal.idConnecte).subscribe(commande =>
     this.commande=commande
     )
}
}
