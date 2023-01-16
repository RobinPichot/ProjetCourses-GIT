import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageInscriptionGlobaleComponent } from './page-inscription-globale/page-inscription-globale.component';
import { HomeComponent } from './home/home.component';
import { AccesCommandesComponent } from './acces-commandes/acces-commandes.component';
import { HistoriqueCommandesComponent } from './historique-commandes/historique-commandes.component';
import { NouvelleCommandeComponent } from './nouvelle-commande/nouvelle-commande.component';

@NgModule({
  declarations: [
    AppComponent,
    PageInscriptionGlobaleComponent,
    HomeComponent,
    AccesCommandesComponent,
    HistoriqueCommandesComponent,
    NouvelleCommandeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
