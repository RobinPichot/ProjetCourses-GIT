
import { NgModule } from '@angular/core';
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

import { RestaurateurComponent } from './restaurateur/restaurateur.component';
import { RestaurateurHttpService } from './restaurateur/restaurateur-http.service';
import { RestaurantHttpService } from './restaurant/restaurant-http.service';

@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    RestaurantComponent,
    NavBarComponent,
    PlatComponent,
    RestaurateurComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [VariableCompteConnecte, PlatHttpService, RestaurateurHttpService, RestaurantHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
