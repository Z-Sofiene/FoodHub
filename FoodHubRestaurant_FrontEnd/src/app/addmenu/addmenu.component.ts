import { Component } from '@angular/core';
import {GestionService} from '../gestion.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-addmenu',
  templateUrl: './addmenu.component.html',
  styleUrl: './addmenu.component.css'
})
export class AddmenuComponent {
  itemMenu: any = {
    id: null,
    titre: '',
    description: '',
    prix: 0,
    rest: { id:0, titre:'' }
  };
  restaurants: any =[]
  constructor(private gest: GestionService, private route: Router) {
    this.getAllRestaurants();
  }
  getAllRestaurants(): void {
    this.gest.getAllRestaurants().subscribe({
      next: (data: any) => {
        this.restaurants = data;
        console.log(this.restaurants);
      },
      error: err => {
        console.error(err);
      },
      complete: () => {}
    });
  }
  addMenu(imageInput: HTMLInputElement): void {
    const file: File | null = imageInput.files ? imageInput.files[0] : null;
    if (file) {
      this.gest.addMenu(file, this.itemMenu).subscribe({
        next: () => {
          alert('Menu added successfully!');
          this.route.navigate(['/menus']);
        },
        error: (err) => {
          console.error('Error adding Menu:', err);
          alert('Failed to add Menu. Please try again.');
        },
      });
    } else {
      alert('Please select an image.');
    }
  }
}
