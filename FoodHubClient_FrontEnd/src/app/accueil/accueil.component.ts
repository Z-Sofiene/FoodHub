import {Component, OnInit} from '@angular/core';
import {GestionService} from '../gestion.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrl: './accueil.component.css'
})
export class AccueilComponent {

  restaurants: any = [];

  constructor(private gest: GestionService, private router: Router) { }

  ngOnInit() {
    this.gest.getAllRestaurants().subscribe({
      next: (data: any) => {
        this.restaurants = data;
        console.log(this.restaurants);  // Log the entire data structure to inspect it
      },
      error: err => {
        console.error(err);
      },
      complete: () => {}
    });
  }

}
