import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { PlatComponent } from './plat/plat.component';
import { PlatHttpService } from './plat/plat-http.service';
import { FormsModule } from '@angular/forms';
import { RestaurateurComponent } from './restaurateur/restaurateur.component';
import { RestaurateurHttpService } from './restaurateur/restaurateur-http.service';
import { RestaurantHttpService } from './restaurant/restaurant-http.service';

@NgModule({
  declarations: [
    AppComponent,
    RestaurantComponent,
    NavBarComponent,
    PlatComponent,
    RestaurateurComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PlatHttpService, RestaurateurHttpService, RestaurantHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
