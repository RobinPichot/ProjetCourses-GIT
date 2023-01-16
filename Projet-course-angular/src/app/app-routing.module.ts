import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccesCommandesComponent } from './acces-commandes/acces-commandes.component';
import { AppComponent } from './app.component';
import { HistoriqueCommandesComponent } from './historique-commandes/historique-commandes.component';
import { HomeComponent } from './home/home.component';
import { NouvelleCommandeComponent } from './nouvelle-commande/nouvelle-commande.component';
import { PageInscriptionGlobaleComponent } from './page-inscription-globale/page-inscription-globale.component';

const routes: Routes = [
  {path: "", component: HomeComponent, pathMatch: 'full'},
  {path: "inscription", component: PageInscriptionGlobaleComponent},
  {path: "accesCommandes", component: AccesCommandesComponent},
  {path: "accesCommandes/historique", component: HistoriqueCommandesComponent},
  {path: "accesCommandes/nouvelle_commande", component: NouvelleCommandeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
