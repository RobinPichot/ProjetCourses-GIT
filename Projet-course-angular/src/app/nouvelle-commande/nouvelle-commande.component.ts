import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Commande } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';
import { NouvelleCommandeHttpService } from './nouvelle-commande-http.service';

@Component({
  selector: 'app-nouvelle-commande',
  templateUrl: './nouvelle-commande.component.html',
  styleUrls: ['./nouvelle-commande.component.scss']
})
export class NouvelleCommandeComponent  {
// export class NouvelleCommandeComponent {

  commandesSansLivreur:Array<Commande>=new Array<Commande>();
  BoutonRechercheCommandeSansLivreur:boolean=false;

  commandesEnCours:Array<Commande>=new Array<Commande>();
  BoutonRechercheCommandeEnCours:boolean=false;
  // commandes:Observable<Array<Commande>>;
  // BoutonAppuye:boolean=false;

  constructor(private nouvelleCommandeService : NouvelleCommandeHttpService, 
    private LoginsMdp : VariableCompteConnecte,
    private router: Router) {
  }

   searchCommandesNonPrisesEnCharge(): void {
     this.nouvelleCommandeService.findAllNonLivreesEtSansLivreur().subscribe(result => {
       this.commandesSansLivreur=result;
     });
    // this.commandes = this.nouvelleCommandeService.findLivreeByLivreur(this.idLivreur);
    this.BoutonRechercheCommandeSansLivreur=true;

   }

   searchCommandesEnCours(): void {
    this.nouvelleCommandeService.findNonLivreeByLivreur(this.LoginsMdp.idConnecte).subscribe(result => {
      this.commandesEnCours=result;
    });
   // this.commandes = this.nouvelleCommandeService.findLivreeByLivreur(this.idLivreur);
    this.BoutonRechercheCommandeEnCours=true;
  }

  confirmerLivraison(id:number): void {
    this.nouvelleCommandeService.updateStatutLivraison(id);
    this.BoutonRechercheCommandeEnCours=false;
  }

  select(id:number): void {
    console.log(this.LoginsMdp.idConnecte);
    this.nouvelleCommandeService.update(id,this.LoginsMdp.idConnecte);
    this.BoutonRechercheCommandeSansLivreur=false;
    this.BoutonRechercheCommandeEnCours=false;
  }

  renvoiPagePrincipaleLivreur():void{
    this.router.navigate(["/livreur"]);
  }

}
