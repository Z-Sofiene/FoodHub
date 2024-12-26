import { Component } from '@angular/core';
import {GestionService} from '../gestion.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-menus',
  templateUrl: './menus.component.html',
  styleUrl: './menus.component.css'
})
export class MenusComponent {

  menus: any = [];
  rest_id!: number;  // Define category ID

  constructor(private gest: GestionService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.rest_id = +params['id']; // '+' converts to a number
      this.getMenusByRestaurant();
    });
  }

  getMenusByRestaurant(): void {
    this.gest.getAllMenusByRestaurantId(this.rest_id).subscribe(
      {
        next: data => {
          this.menus = data;
        },
        error: err => {},
        complete: () => { }

      }
    );
  }

  deleteMenu(id: number): void {
    this.gest.deleteMenu(id).subscribe(
      {
        next: () => {
          this.menus = this.menus.filter((c: { id: number; }) => c.id !== id);
        },
        error: err => {},
        complete: () => { }
      }
    );
  }

}
