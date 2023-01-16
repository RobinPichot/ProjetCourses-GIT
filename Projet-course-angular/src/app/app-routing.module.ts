import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlatComponent } from './plat/plat.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { RestaurateurComponent } from './restaurateur/restaurateur.component';

const routes: Routes = [
  {path: "plat", component: PlatComponent},
  {path: "restaurant", component: RestaurantComponent},
  {path: "restaurateur", component: RestaurateurComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
