import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Restaurant } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';
import { PageRestaurantRechercheHttpService } from './page-restaurant-recherche-http.service';

@Component({
  selector: 'app-client-restaurant-recherche',
  templateUrl: './client-restaurant-recherche.component.html',
  styleUrls: ['./client-restaurant-recherche.component.scss']
})
export class ClientRestaurantRechercheComponent  implements OnInit{
 ville:string;
 restauId:number;
  restaurants : Array<Restaurant>;
  constructor(private variableGlobale : VariableCompteConnecte,private http: PageRestaurantRechercheHttpService,
    private router: Router,){}
 
  ngOnInit() {


    console.log(this.variableGlobale.villeRecherche)
    console.log(this.variableGlobale.idConnecte)
    console.log(this.variableGlobale.loginConnecte)
    this.recherche();
  }

  recherche(){
    this.http.charge(this.variableGlobale.villeRecherche).subscribe(
      (result) => { this.restaurants=result;
        console.log(this.restaurants)
        this.ville=this.variableGlobale.villeRecherche;
  });

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
menu(id:number){
this.variableGlobale.idRestaurantRechercheParClient=id;
this.router.navigate(['/platsRechercheRestaurant'])
  
}
}