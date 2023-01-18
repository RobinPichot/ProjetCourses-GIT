import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { VariableCompteConnecte } from '../VariableGlobale';

@Component({
  selector: 'app-client-page-recherche',
  templateUrl: './client-page-recherche.component.html',
  styleUrls: ['./client-page-recherche.component.scss']
})
export class ClientPageRechercheComponent {

  ville:string;

  constructor(       private router: Router,
    private variableGlobal: VariableCompteConnecte
    ){}
    
    recherche(){

      this.variableGlobal.villeRecherche=this.ville;
      this.router.navigate(['/clientRestaurantRecherche']);
  //mettre le chemin pour page suivante       
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
