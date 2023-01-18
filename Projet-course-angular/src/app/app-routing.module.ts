import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccesCommandesComponent } from './acces-commandes/acces-commandes.component';
import { HistoriqueCommandesComponent } from './historique-commandes/historique-commandes.component';
import { NouvelleCommandeComponent } from './nouvelle-commande/nouvelle-commande.component';
import { PageInscriptionGlobaleComponent } from './page-inscription-globale/page-inscription-globale.component';
import { ClientPageRechercheComponent } from './client-page-recherche/client-page-recherche.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { PlatComponent } from './plat/plat.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { RestaurateurComponent } from './restaurateur/restaurateur.component';
import { CompteUtilisateurComponent } from './compte-utilisateur/compte-utilisateur.component';
import { ClientRestaurantRechercheComponent } from './client-restaurant-recherche/client-restaurant-recherche.component';
import { PanierComponent } from './panier/panier.component';
import { ClientAttenteLiveurComponent } from './client-attente-liveur/client-attente-liveur.component';
import { PageClientRecherchePlatComponent } from './page-client-recherche-plat/page-client-recherche-plat.component';

const routes: Routes = [
  {path: "inscription", component: PageInscriptionGlobaleComponent},
  {path: "accesCommandes", component: AccesCommandesComponent},
  {path: "accesCommandes/historique", component: HistoriqueCommandesComponent},
  {path: "accesCommandes/nouvelle_commande", component: NouvelleCommandeComponent},
  {path: "", component: ConnexionComponent, pathMatch :'full'},
  {path:"clientRecherche", component: ClientPageRechercheComponent},
  {path: "plat", component: PlatComponent},
  {path: "restaurant", component: RestaurantComponent},
  {path: "restaurateur", component: RestaurateurComponent},
  {path: "client", component: CompteUtilisateurComponent},
  {path: "panier", component: PanierComponent},
  {path: "clientRestaurantRecherche", component: ClientRestaurantRechercheComponent},
  {path: "client/attenteLivreur", component: ClientAttenteLiveurComponent},
  {path: "platsRechercheRestaurant", component: PageClientRecherchePlatComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
