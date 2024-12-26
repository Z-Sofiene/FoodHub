import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AccueilComponent} from './accueil/accueil.component';
import {RestaurantComponent} from './restaurant/restaurant.component';
import {LayoutComponent} from './layout/layout.component';

const routes: Routes = [

  {path:'',
    component: LayoutComponent,
    children : [
      {path: 'accueil', component: AccueilComponent},
      {path: 'restaurant', component: RestaurantComponent},
      {path: 'panier', component: RestaurantComponent}
      ]},
  {path:'', redirectTo: '/accueil', pathMatch: 'full'}

]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
