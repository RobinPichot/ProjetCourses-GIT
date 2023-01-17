import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccesCommandesComponent } from './acces-commandes/acces-commandes.component';
import { AppComponent } from './app.component';
import { HistoriqueCommandesComponent } from './historique-commandes/historique-commandes.component';
import { HomeComponent } from './home/home.component';
import { NouvelleCommandeComponent } from './nouvelle-commande/nouvelle-commande.component';
import { PageInscriptionGlobaleComponent } from './page-inscription-globale/page-inscription-globale.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { PlatComponent } from './plat/plat.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { RestaurateurComponent } from './restaurateur/restaurateur.component';
import { CompteUtilisateurComponent } from './compte-utilisateur/compte-utilisateur.component';
import { PanierComponent } from './panier/panier.component';

const routes: Routes = [
  {path: "inscription", component: PageInscriptionGlobaleComponent},
  {path: "accesCommandes", component: AccesCommandesComponent},
  {path: "accesCommandes/historique", component: HistoriqueCommandesComponent},
  {path: "accesCommandes/nouvelle_commande", component: NouvelleCommandeComponent},
  {path: "", component: ConnexionComponent, pathMatch :'full'},
  {path: "plat", component: PlatComponent},
  {path: "restaurant", component: RestaurantComponent},
  {path: "restaurateur", component: RestaurateurComponent},
  {path: "client", component: CompteUtilisateurComponent},
  {path: "panier", component: PanierComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
