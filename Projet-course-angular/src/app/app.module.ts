
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { VariableCompteConnecte } from './VariableGlobale';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { PlatComponent } from './plat/plat.component';
import { PlatHttpService } from './plat/plat-http.service';
import { PageInscriptionGlobaleComponent } from './page-inscription-globale/page-inscription-globale.component';
import { HomeComponent } from './home/home.component';
import { AccesCommandesComponent } from './acces-commandes/acces-commandes.component';
import { CompteUtilisateurComponent } from './compte-utilisateur/compte-utilisateur.component';
import { HistoriqueCommandesComponent } from './historique-commandes/historique-commandes.component';
import { NouvelleCommandeComponent } from './nouvelle-commande/nouvelle-commande.component';

import { RestaurateurComponent } from './restaurateur/restaurateur.component';
import { RestaurateurHttpService } from './restaurateur/restaurateur-http.service';
import { RestaurantHttpService } from './restaurant/restaurant-http.service';
import { PanierComponent } from './panier/panier.component';
import { ClientPageRechercheComponent } from './client-page-recherche/client-page-recherche.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ClientRestaurantRechercheComponent } from './client-restaurant-recherche/client-restaurant-recherche.component';
import { PageRestaurantRechercheHttpService } from './client-restaurant-recherche/page-restaurant-recherche-http.service';
import { ClientAttenteLiveurComponent } from './client-attente-liveur/client-attente-liveur.component';
import { PageClientRecherchePlatComponent } from './page-client-recherche-plat/page-client-recherche-plat.component';
import { CommandeRestauComponent } from './commande-restau/commande-restau.component';

@NgModule({
  declarations: [
    PageInscriptionGlobaleComponent,
    HomeComponent,
    AccesCommandesComponent,
    HistoriqueCommandesComponent,
    NouvelleCommandeComponent,
    AppComponent,
    ConnexionComponent,
    CompteUtilisateurComponent,
    RestaurantComponent,
    NavBarComponent,
    PlatComponent,
    RestaurateurComponent,
    ClientPageRechercheComponent,
    ClientRestaurantRechercheComponent,
    PanierComponent,
    ClientAttenteLiveurComponent,
    PageClientRecherchePlatComponent,
    CommandeRestauComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FontAwesomeModule
  ],
  providers: [VariableCompteConnecte, PlatHttpService, RestaurateurHttpService, RestaurantHttpService,PageRestaurantRechercheHttpService],
  bootstrap: [AppComponent],
  schemas : [NO_ERRORS_SCHEMA]
})
export class AppModule { }
