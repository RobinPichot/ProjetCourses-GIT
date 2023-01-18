import { Component } from '@angular/core';
import { Compte, FormCompte } from '../model';
import { Livreur } from '../model';
import { Restaurateur } from '../model';
import { Client } from '../model';
import { PageInscriptionGlobaleHttpService } from './page-inscription-globale-http.service';

@Component({
  selector: 'app-page-inscription-globale',
  templateUrl: './page-inscription-globale.component.html',
  styleUrls: ['./page-inscription-globale.component.scss']
})
export class PageInscriptionGlobaleComponent {


formCompte: FormCompte = new FormCompte();
password2:string="";
typesDeCompte : Array<string>=['Restaurateur','Client','Livreur'];
typeSelected:boolean=false;

  constructor(private pageInscriptionGlobaleService: PageInscriptionGlobaleHttpService) {
  }

  save(): void {
    this.pageInscriptionGlobaleService.createFromInscription(this.formCompte);
    this.cancel();
  }

  cancel(): void {
    this.formCompte = null; 
  }

  changerTypeCompte(type:string): void {
    this.formCompte.type=type.toLowerCase(); 
    this.typeSelected=true;
  }

  editTypeCompte(): void { 
    this.typeSelected=false;
  } 
}
