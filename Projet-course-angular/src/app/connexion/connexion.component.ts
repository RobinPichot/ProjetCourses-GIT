import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { empty, Observable } from "rxjs";
import { ClientAttenteHttpService } from "../client-attente-liveur/client-attente-http.service";
import { Commande, Compte } from "../model";
import { VariableCompteConnecte } from "../VariableGlobale";
import { ConnexionHttpService } from "./connexion-http.service";

@Component({
  selector: "app-connexion",
  templateUrl: "./connexion.component.html",
  styleUrls: ["./connexion.component.scss"],
})
export class ConnexionComponent {
  compte: Compte;
  user: string;
  mdp: string;
  msg: string = null;
  last : Commande;
  commande : Array<Commande> = new Array<Commande>();
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
          case "Client":
            this.httpConnection
              .findCommandeById(this.variableGlobal.idConnecte)
              .subscribe((commande) => { console.log(commande)
                if (!commande[0]){
                  this.router.navigate(["/clientRecherche"]);
                }
                else {  this.commande = commande;
                this.last = [...this.commande].pop();
                console.log("connecté en Client");
                if (this.last.livree == false && this.last.payee==true) {
                  //route a définir
                  this.router.navigate(["client/attenteLivreur"]);
                } else this.router.navigate(["/clientRecherche"]);}
              });
            break;
          case "Restaurateur":
            console.log("Restaurateur"); //route a définir
            this.router.navigate(["restaurateur"]);
            break;

          case 'Livreur':
            console.log('Livreur'); //route a définir
            this.router.navigate(["livreur"]);break;
        }
        this.user = "";
        this.mdp = "";
      },
      (errors) => {
        console.log(errors);
        this.msg = "Login/Mot de passe incorrect(s)";

        this.user = '';
        this.mdp = '';
      }
    );
  }

  inscription() {
    this.router.navigate(["/inscription"]);
  }


checkLoginAndandMdp(){

  if(this.login){
    
  }
}

}



