import { Component, OnInit, ɵisListLikeIterable } from '@angular/core';
import { platformBrowser } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Commande, Panier } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';
import { PanierHttpService } from './panier-http.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent implements OnInit {

paniers: Array<Panier>;
id:number=4;
totalPrix: number = 0;
selectedOption: string ='';
commande:Commande;

  constructor(private router: Router,private panierService : PanierHttpService,private variableGlobal : VariableCompteConnecte){
  let idCon = this.variableGlobal.idConnecte;
  
}
  ngOnInit(): void {
    this.list();
  }


list(): void {
  // TODO régler ici, on attend une liste de paniers, et pas un seul panier

  // FIXME une fois la liste récupérée
    this.panierService.findPanierByIdCommandeByIdClient(this.variableGlobal.idConnecte).subscribe(paniers => {
    this.paniers = paniers;
    this.totalPrix = paniers.reduce((acc, panier) => acc + (panier.plat.prix * panier.quantite), 0);
    
    // this.totalPrix = paniers.reduce((acc, panier) => {
    //   return acc + (panier.plat.prix * panier.quantite);
    // }, 0);

    // this.totalPrix = paniers.reduce(function (acc, panier)  {
    //   return acc + (panier.plat.prix * panier.quantite);
    // }, 0);
  });
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
commandepaye(){
this.panierService.updateStatutPaye(this.variableGlobal.idConnecte);
}



}

