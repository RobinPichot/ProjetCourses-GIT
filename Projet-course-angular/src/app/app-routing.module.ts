import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './connexion/connexion.component';
import { PlatComponent } from './plat/plat.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { RestaurateurComponent } from './restaurateur/restaurateur.component';

const routes: Routes = [
  {path: "", component: ConnexionComponent, pathMatch :'full'},
  {path: "plat", component: PlatComponent},
  {path: "restaurant", component: RestaurantComponent},
  {path: "restaurateur", component: RestaurateurComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
