import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
constructor(private router: Router,private clientAttenteService : ClientAttenteHttpService,private variableGlobal : VariableCompteConnecte){
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
logOut(){
  this.variableGlobal.idConnecte=null;
  this.variableGlobal.loginConnecte=null;
  this.variableGlobal.villeRecherche=null;
  this.router.navigate(['']);
}


}
