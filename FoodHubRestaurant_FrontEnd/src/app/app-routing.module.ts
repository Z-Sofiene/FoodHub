import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LayoutComponent} from './layout/layout.component';
import {RestaurantsComponent} from './restaurants/restaurants.component';
import {AddmenuComponent} from './addmenu/addmenu.component';
import {MenusComponent} from './menus/menus.component';
import {RestaurantdetailsComponent} from './restaurantdetails/restaurantdetails.component';
import {MenudetailsComponent} from './menudetails/menudetails.component';
import {AddrestaurantComponent} from './addrestaurant/addrestaurant.component';
import {ConnexionComponent} from './connexion/connexion.component';
import {AuthGuard} from './auth.guard';




const routes: Routes = [
  {path: 'login', component:ConnexionComponent},
  {path: '',
    component: LayoutComponent,
    canActivate : [AuthGuard],
    children :[
        {path: 'restaurants', component: RestaurantsComponent },
        {path: 'addRestaurant', component: AddrestaurantComponent },
        {path: 'addMenu', component: AddmenuComponent },
        {path: 'menus/:id', component: MenusComponent },
        {path: 'detailRestaurant', component: RestaurantdetailsComponent},
        {path: 'detailMenu', component: MenudetailsComponent}]
    },
  {path:'', redirectTo: '/login', pathMatch: 'full'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
