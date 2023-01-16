import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './connexion/connexion.component';
import { CompteUtilisateurComponent } from './compte-utilisateur/compte-utilisateur.component';

const routes: Routes = [
  {path: "", component: ConnexionComponent, pathMatch :'full'},
  {path: "client", component: CompteUtilisateurComponent, pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
