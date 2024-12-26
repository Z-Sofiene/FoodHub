import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RestaurantsComponent } from './restaurants/restaurants.component';
import { MenusComponent } from './menus/menus.component';
import { AddmenuComponent } from './addmenu/addmenu.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule, provideHttpClient, withFetch} from '@angular/common/http';
import {GestionService} from './gestion.service';
import { RestaurantdetailsComponent } from './restaurantdetails/restaurantdetails.component';
import { MenudetailsComponent } from './menudetails/menudetails.component';
import { LayoutComponent } from './layout/layout.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { AddrestaurantComponent } from './addrestaurant/addrestaurant.component';
import {AuthGuard} from './auth.guard';

@NgModule({
  declarations: [
    AppComponent,
    AddrestaurantComponent,
    MenusComponent,
    RestaurantsComponent,
    AddmenuComponent,
    RestaurantdetailsComponent,
    MenudetailsComponent,
    LayoutComponent,
    ConnexionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,

  ],
  providers: [
    provideHttpClient(withFetch()),
    provideClientHydration(),
    GestionService,
    AuthGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
