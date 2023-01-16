import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Client, Compte, FormClient } from '../model';
import { VariableCompteConnecte } from '../VariableGlobale';
import { CompteUtilisateurHttpService } from './compte-utilisateur-http.service';

@Component({
  selector: 'app-compte-utilisateur',
  templateUrl: './compte-utilisateur.component.html',
  styleUrls: ['./compte-utilisateur.component.scss']
})
export class CompteUtilisateurComponent {

  
  client: Client = null;
  id : number;
  formClient : Client = null;
  

 constructor(private route: ActivatedRoute,private clientService : CompteUtilisateurHttpService,private variableGlobal : VariableCompteConnecte){ 
  let idCon = this.variableGlobal.idConnecte;
 }

 list() : Array<Client>{
  return this.clientService.findAll();
 }

 edit(id: number): void {
  this.clientService.findById(id).subscribe(resp => {
    this.formClient = resp;
  });
}

save(): void {
  this.clientService.update(this.formClient);
  this.cancel();
}

cancel(): void {
  this.formClient = null;
}
}