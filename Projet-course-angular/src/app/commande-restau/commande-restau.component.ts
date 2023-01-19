import { Component, OnInit } from '@angular/core';
import { AccesCommandesHttpService } from '../acces-commandes/acces-commandes-http.service';
import { Commande } from '../model';
import { OnDestroy } from '@angular/core';
import { VariableCompteConnecte } from '../VariableGlobale';

@Component({
  selector: 'app-commande-restau',
  templateUrl: './commande-restau.component.html',
  styleUrls: ['./commande-restau.component.scss']
})
export class CommandeRestauComponent implements OnInit {

  formCommandes: Array <Commande> = new Array <Commande>();
  formCommande: Commande = null;

  constructor(private acceservice: AccesCommandesHttpService, private variableGlo: VariableCompteConnecte){}
    
    add():void {
      this.formCommande = new Commande();
    }
  
    edit(id: number): void {
      this.acceservice.findById(id).subscribe(resp => {
        this.formCommande = resp;
      });
    }
  
    save(): void {
      if(this.formCommande.id) { // UPDATE
        this.acceservice.update(this.formCommande);
      } else { // CREATE
        this.acceservice.create(this.formCommande);
      }
  
      this.cancel();
    }
  
    cancel(): void {
      this.formCommande = null;
    }
  
    remove(id: number): void {
      this.acceservice.remove(id);
    }
   
  
  ngOnInit(): void {
    // this.restaurantService.findById(this.variableGlobale.idplatrestau).subscribe(result => {this.formRestaur= result});
      // this.restaurateurService.findById(this.variableGlobale.idConnecte).subscribe(result => {this.formRestaurateur= result});
      this.acceservice.findByIdRestau(this.variableGlo.idplatrestau).subscribe(result => {this.formCommandes= result; });
      // this.listRestaurant();
  }
}
