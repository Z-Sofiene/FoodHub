import { Component } from '@angular/core';
import { GestionService } from '../gestion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addrestaurant',
  templateUrl: './addrestaurant.component.html',
  styleUrls: ['./addrestaurant.component.css'],
})
export class AddrestaurantComponent {
  restaurant: any = {
    id: null,
    titre: '',
    description: '',
    adresse: '',
    specialite: '',
  };

  constructor(private gest: GestionService, private route: Router) {}

  addRestaurant(imageInput: HTMLInputElement): void {
    const file: File | null = imageInput.files ? imageInput.files[0] : null;
    if (file) {
      this.gest.addRestaurant(file, this.restaurant).subscribe({
        next: () => {
          alert('Restaurant added successfully!');
          this.route.navigate(['/restaurants']);
        },
        error: (err) => {
          console.error('Error adding restaurant:', err);
          alert('Failed to add restaurant. Please try again.');
        },
      });
    } else {
      alert('Please select an image.');
    }
  }
}
