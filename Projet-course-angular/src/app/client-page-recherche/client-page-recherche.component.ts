import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { VariableCompteConnecte } from '../VariableGlobale';
import { ClientPageRechercheHttpService } from './client-page-recherche-http.service';

@Component({
  selector: 'app-client-page-recherche',
  templateUrl: './client-page-recherche.component.html',
  styleUrls: ['./client-page-recherche.component.scss']
})
export class ClientPageRechercheComponent {

  ville:string;

  constructor(       private router: Router,
    private variableGlobal: VariableCompteConnecte,
    private clientService : ClientPageRechercheHttpService
    ){}
    
    recherche(){

      this.variableGlobal.villeRecherche=this.ville;
      this.router.navigate(['/clientRestaurantRecherche']);
      this.clientService.create(this.variableGlobal.idConnecte);    
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
