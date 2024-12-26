import {Component, OnInit} from '@angular/core';
import {GestionService} from '../gestion.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrl: './restaurants.component.css'
})
export class RestaurantsComponent implements OnInit {

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


  deleteRestaurant(id: number): void {
    this.gest.deleteRestaurant(id).subscribe(
      {
        next: () => {
          this.restaurants = this.restaurants.filter((c: { id: number; }) => c.id !== id);
        },
        error: err => {},
        complete: () => { }
      }
    );
  }

}
