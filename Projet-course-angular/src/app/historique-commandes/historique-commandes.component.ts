import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Commande, Compte, Restaurant } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';
import { HistoriqueCommandesHttpService } from './historique-commandes-http.service';

@Component({
  selector: 'app-historique-commandes',
  templateUrl: './historique-commandes.component.html',
  styleUrls: ['./historique-commandes.component.scss']
})
export class HistoriqueCommandesComponent implements OnInit {

  idLivreur:number=2;
  commandes:Array<Commande>=new Array<Commande>();
  restaurants:Array<Restaurant>=new Array<Restaurant>();
  comptes:Array<Compte>=new Array<Compte>();
  // commandes:Observable<Array<Commande>>;
  BoutonAppuye:boolean=false;

  constructor(private historiqueCommandesService : HistoriqueCommandesHttpService, 
    private LoginsMdp : VariableCompteConnecte,
    private router: Router) {
  }

   search(): void {
     this.historiqueCommandesService.findLivreeByLivreur(this.LoginsMdp.idConnecte).subscribe(result => {
       this.commandes=result;
     });
    // this.commandes = this.historiqueCommandesService.findLivreeByLivreur(this.idLivreur);
    this.BoutonAppuye=true;
   }

   ngOnInit(){
    this.search();
  }

   findAllRestaurants(): void {
    this.historiqueCommandesService.findAllRestaurants().subscribe(result => {
      this.restaurants=result;
    });
  }

  findAllComptes(): void {
    this.historiqueCommandesService.findAllComptes().subscribe(result => {
      this.comptes=result;
    });
  }

  renvoiPagePrincipaleLivreur():void{
    this.router.navigate(["/livreur"]);
  }

  






}
