import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Plat } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';
import { PageClientRecherchePlatHttpService } from './page-client-recherche-plat-http.service';

@Component({
  selector: 'app-page-client-recherche-plat',
  templateUrl: './page-client-recherche-plat.component.html',
  styleUrls: ['./page-client-recherche-plat.component.scss']
})
export class PageClientRecherchePlatComponent {

  plats: Array<Plat>;

  constructor(private variableGlobale : VariableCompteConnecte,private router: Router,private http:PageClientRecherchePlatHttpService){}


  ngOnInit() {


    console.log(this.variableGlobale.villeRecherche)
    console.log(this.variableGlobale.idConnecte)
    console.log(this.variableGlobale.loginConnecte)
    this.platsRecherche();
  }

  platsRecherche(){
      this.http.chargePlats().subscribe(
      (result) => { this.plats=result;
        console.log(this.plats)
  })
}
newSearch(){
  this.router.navigate(['/clientRecherche']);
}



monCompte(){
  //chemin vers mon compte
  console.log("MON COMPTE !")
  this.router.navigate(['/client/']); //POUR MON COMPTE DU CLIENT CO (CHANGER REQUETE DANS COMPTE UTILISATEUR APRES)

}

logOut(){
  this.variableGlobale.idConnecte=null;
  this.variableGlobale.loginConnecte=null;
  this.variableGlobale.villeRecherche=null;
  this.variableGlobale.idRestaurantRechercheParClient=null;
  this.router.navigate(['']);
}
monPanier(){
  //chemin vers mon panier
  this.router.navigate(['/panier']);
  console.log("MON PANIER !")

}
}
