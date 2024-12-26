import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccueilComponent } from './accueil/accueil.component';
import { PanierComponent } from './panier/panier.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { LayoutComponent } from './layout/layout.component';
import {GestionService} from './gestion.service';
import {HttpClientModule, provideHttpClient, withFetch} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent,
    PanierComponent,
    RestaurantComponent,
    LayoutComponent
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

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
