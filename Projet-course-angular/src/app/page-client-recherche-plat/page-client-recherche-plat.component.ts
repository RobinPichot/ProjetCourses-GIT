import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { Plat } from "../model";
import { VariableCompteConnecte } from "../VariableGlobale";
import { PageClientRecherchePlatHttpService } from "./page-client-recherche-plat-http.service";

@Component({
  selector: "app-page-client-recherche-plat",
  templateUrl: "./page-client-recherche-plat.component.html",
  styleUrls: ["./page-client-recherche-plat.component.scss"],
})
export class PageClientRecherchePlatComponent {
  nomRestau: string;
  plats: Array<Plat>;
  quantite: number[];
  constructor(
    private variableGlobale: VariableCompteConnecte,
    private router: Router,
    private http: PageClientRecherchePlatHttpService
  ) {}

  ngOnInit() {
    this.nomRestau = this.variableGlobale.nomRestaurantRechercheParClient;
    this.platsRecherche();
  }

  platsRecherche() {
    this.http.chargePlats().subscribe((result) => {
      this.plats = result;

      this.quantite = this.plats.map((p) => 1);
    });
  }
  newSearch() {
    this.http.remove(this.variableGlobale.idCommandeEnCour);
    this.router.navigate(["/clientRecherche"]);
  }

  monCompte() {
    //chemin vers mon compte
    console.log("MON COMPTE !");
    this.router.navigate(["/client/"]); //POUR MON COMPTE DU CLIENT CO (CHANGER REQUETE DANS COMPTE UTILISATEUR APRES)
  }

  order(plat: Plat, index: number) {
    const quantite = this.quantite[index];
    this.variableGlobale.idRestauLorsCommande=plat.restaurant.id;
    this.http.ajoutPanier(this.variableGlobale.idCommandeEnCour,plat.id,quantite)
    alert("Le plat : "+plat.nom+" a été ajouté au panier "+quantite+" fois !")
  
  }

  logOut() {
    this.http.remove(this.variableGlobale.idCommandeEnCour);
    this.variableGlobale.idConnecte = null;
    this.variableGlobale.loginConnecte = null;
    this.variableGlobale.villeRecherche = null;
    this.variableGlobale.idRestaurantRechercheParClient = null;
    this.router.navigate([""]);
  }
  monPanier() {
    //chemin vers mon panier
    this.router.navigate(["/panier"]);
    console.log("MON PANIER !");
  }
}
