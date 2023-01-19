import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Commande, Restaurant } from '../model';
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
 nomRestau:string;
  restaurants : Array<Restaurant>;
 
  constructor(private variableGlobal : VariableCompteConnecte,private http: PageRestaurantRechercheHttpService,
    private router: Router,){}
 
  ngOnInit() {
    this.ville=this.variableGlobal.villeRecherche;
    this.recherche();

  
  }

  recherche(){
    this.http.charge(this.variableGlobal.villeRecherche).subscribe(
      (result) => { this.restaurants=result;
        console.log(this.restaurants)
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
  this.variableGlobal.idConnecte=null;
  this.variableGlobal.loginConnecte=null;
  this.variableGlobal.villeRecherche=null;
  this.variableGlobal.idRestaurantRechercheParClient=null;
  this.router.navigate(['']);
}
monPanier(){
  //chemin vers mon panier
  this.router.navigate(['/panier']);
  console.log("MON PANIER !")

}
menu(id:number,nom:string,ouvert:boolean){
  if(!ouvert){
    alert("restau fermé")
  }else{
this.variableGlobal.idRestaurantRechercheParClient=id;
this.variableGlobal.nomRestaurantRechercheParClient=nom;
this.router.navigate(['/platsRechercheRestaurant'])
  }
}
}