import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { VariableCompteConnecte } from './VariableGlobale';
import { CompteUtilisateurComponent } from './compte-utilisateur/compte-utilisateur.component';

@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    HomeComponent
    CompteUtilisateurComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [    VariableCompteConnecte
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
