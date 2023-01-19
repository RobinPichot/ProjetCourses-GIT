import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ClientAttenteHttpService } from '../client-attente-liveur/client-attente-http.service';
import { Commande, Compte } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';
import { ConnexionHttpService } from './connexion-http.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss'],
})
export class ConnexionComponent {
  compte: Compte;
  user: string;
  mdp: string;
  commande : Commande;
  constructor(
    private httpConnection: ConnexionHttpService,
    private router: Router,
    private variableGlobal: VariableCompteConnecte
  ) {}

  login() {
    this.httpConnection.login(this.user, this.mdp).subscribe(
      (result) => {
        this.compte = result;

        this.variableGlobal.idConnecte = this.compte.id;
        this.variableGlobal.loginConnecte = this.compte.login;

        switch (this.compte.classType) {
          case 'Client':
            this.httpConnection.findCommandeById(this.variableGlobal.idConnecte).subscribe(
              commande =>{
              this.commande=commande
        
            console.log('connecté en Client');
            if(this.commande.livree==false){ //route a définir
              this.router.navigate(['client/attenteLivreur']);}
            else  
            this.router.navigate(['/clientRecherche']);
           
          });
          break;
          case "Restaurateur" : console.log("Restaurateur"); //route a définir
            this.router.navigate(["restaurateur"]); break;

          case 'Livreur':
            console.log('Livreur'); //route a définir
            break;
        }
        this.user = '';
        this.mdp = '';
      },
      (errors) => {
        console.log(errors);

        alert('invalid user/password');
        this.user = '';
        this.mdp = '';
      }
    );
  }

  inscription(){
    this.router.navigate(['/inscription'])
  }
}
