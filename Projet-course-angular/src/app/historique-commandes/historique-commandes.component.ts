import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Commande, Compte } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';
import { HistoriqueCommandesHttpService } from './historique-commandes-http.service';

@Component({
  selector: 'app-historique-commandes',
  templateUrl: './historique-commandes.component.html',
  styleUrls: ['./historique-commandes.component.scss']
})
export class HistoriqueCommandesComponent {

  idLivreur:number=2;
  commandes:Array<Commande>=new Array<Commande>();
  // commandes:Observable<Array<Commande>>;
  BoutonAppuye:boolean=false;

  constructor(private historiqueCommandesService : HistoriqueCommandesHttpService, private LoginsMdp : VariableCompteConnecte) {
  }

   search(): void {
     this.historiqueCommandesService.findLivreeByLivreur(this.LoginsMdp.idConnecte).subscribe(result => {
       this.commandes=result;
     });
    // this.commandes = this.historiqueCommandesService.findLivreeByLivreur(this.idLivreur);
    this.BoutonAppuye=true;

   }

  






}
