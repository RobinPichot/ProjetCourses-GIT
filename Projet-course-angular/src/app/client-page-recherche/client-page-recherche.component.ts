import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { faThumbsDown } from "@fortawesome/free-solid-svg-icons";
import { Commande } from "../model";
import { VariableCompteConnecte } from "../VariableGlobale";
import { ClientPageRechercheHttpService } from "./client-page-recherche-http.service";

@Component({
  selector: "app-client-page-recherche",
  templateUrl: "./client-page-recherche.component.html",
  styleUrls: ["./client-page-recherche.component.scss"],
})
export class ClientPageRechercheComponent {
  ville: string;
  commande: Array<Commande>;
  last: Commande;
  constructor(
    private router: Router,
    private variableGlobal: VariableCompteConnecte,
    private clientService: ClientPageRechercheHttpService
  ) {}

  recherche() {
    this.variableGlobal.villeRecherche = this.ville;
    this.router.navigate(["/clientRestaurantRecherche"]);
    this.clientService.create(this.variableGlobal.idConnecte).subscribe(() => {
      this.clientService
        .findCommandeById(this.variableGlobal.idConnecte)
        .subscribe((commande) => {
          this.commande = commande;
          this.last = [...this.commande].pop();
          this.variableGlobal.idCommandeEnCour = this.last.id;
          console.log(this.variableGlobal.idCommandeEnCour);
        });
    });
  }

  monCompte() {
    //chemin vers mon compte
    console.log("MON COMPTE !");
    this.router.navigate(["/client/"]); //POUR MON COMPTE DU CLIENT CO (CHANGER REQUETE DANS COMPTE UTILISATEUR APRES)
  }

  monPanier() {
    //chemin vers mon panier
    this.router.navigate(["/panier"]);
    console.log("MON PANIER !");
  }

  logOut() {
    this.variableGlobal.idConnecte = null;
    this.variableGlobal.loginConnecte = null;
    this.variableGlobal.villeRecherche = null;
    this.router.navigate([""]);
  }
}
