import { Component } from '@angular/core';
import { Commande } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';
import { NouvelleCommandeHttpService } from './nouvelle-commande-http.service';

@Component({
  selector: 'app-nouvelle-commande',
  templateUrl: './nouvelle-commande.component.html',
  styleUrls: ['./nouvelle-commande.component.scss']
})
export class NouvelleCommandeComponent {

  commandesSansLivreur:Array<Commande>=new Array<Commande>();
  BoutonRechercheCommandeSansLivreur:boolean=false;

  commandesEnCours:Array<Commande>=new Array<Commande>();
  BoutonRechercheCommandeEnCours:boolean=false;
  // commandes:Observable<Array<Commande>>;
  // BoutonAppuye:boolean=false;

  constructor(private nouvelleCommandeService : NouvelleCommandeHttpService, private LoginsMdp : VariableCompteConnecte) {
  }

  idLivreur:number=2;
  idCommande:number=2;

   searchCommandesNonPrisesEnCharge(): void {
     this.nouvelleCommandeService.findAllNonLivreesEtSansLivreur().subscribe(result => {
       this.commandesSansLivreur=result;
     });
    // this.commandes = this.nouvelleCommandeService.findLivreeByLivreur(this.idLivreur);
    this.BoutonRechercheCommandeSansLivreur=true;

   }

   searchCommandesEnCours(): void {
    this.nouvelleCommandeService.findNonLivreeByLivreur(this.idLivreur).subscribe(result => {
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
    this.nouvelleCommandeService.update(id,this.idLivreur);
    this.BoutonRechercheCommandeSansLivreur=false;
    this.BoutonRechercheCommandeEnCours=false;
  }




}
