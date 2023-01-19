import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Client, Compte } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';
import { CompteUtilisateurHttpService } from './compte-utilisateur-http.service';

@Component({
  selector: 'app-compte-utilisateur',
  templateUrl: './compte-utilisateur.component.html',
  styleUrls: ['./compte-utilisateur.component.scss']
})
export class CompteUtilisateurComponent implements OnInit  {

  
  clients: Client;
  id : number;
  formClient : Client = null;
  

 constructor(private router: Router,private clientService : CompteUtilisateurHttpService,private variableGlobal : VariableCompteConnecte){ 
  let idCon = this.variableGlobal.idConnecte;
}

 list() : Array<Client>{
  return this.clientService.findAll();
 }

 ngOnInit(): void {
  this.afficher();
}

afficher(){
  this.clientService.findById(this.variableGlobal.idConnecte).subscribe(clients => {
    this.clients = clients;
  });
}

 edit(id: number): void {
  this.clientService.findById(id).subscribe(resp => {
    this.formClient = resp;
  });
}

save(): void {
  this.clientService.update(this.formClient).subscribe(client => {
    this.clients = client;
  });
  this.cancel();
}

cancel(): void {
  this.formClient = null;
}
monCompte(){
  //chemin vers mon compte
  console.log("MON COMPTE !")
  this.router.navigate(['/client/']); //POUR MON COMPTE DU CLIENT CO (CHANGER REQUETE DANS COMPTE UTILISATEUR APRES)
}

monPanier(){
  //chemin vers mon panier
  this.router.navigate(['/panier']);
  console.log("MON PANIER !")

}

logOut(){
  this.variableGlobal.idConnecte=null;
  this.variableGlobal.loginConnecte=null;
  this.variableGlobal.villeRecherche=null;
  this.router.navigate(['']);
}
}
