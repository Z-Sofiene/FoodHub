import { Component } from '@angular/core';
import {GestionService} from '../gestion.service';
import {ActivatedRoute, Router} from '@angular/router';
import {PanierService} from '../panier.service';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrl: './restaurant.component.css'
})
export class RestaurantComponent {
  restaurant:any;
  menu:any=[];
  id:number=0;
  pan: any = [];
  constructor(private gest: GestionService, private ActRoute:ActivatedRoute, private gestPan:PanierService) {
    this.id=this.ActRoute.snapshot.params['id'];
    this.getMenu();
    this.getRestaurant();
    this.getCart();
  }

  getRestaurant(){
    this.gest.getRestaurant(this.id).subscribe(
      {
        "next":(data)=>{
          this.restaurant=data;
        },
        "error":(err)=>{},
        "complete":()=>{}
      }
    )
  }

  getMenu(){
    this.gest.getAllMenusByRestaurantId(this.id).subscribe(
      {
        "next":(data)=>{
          this.menu=data;
        },
        "error":(err)=>{},
        "complete":()=>{}
      }
    )
  }


  getCart(){
    this.pan=this.gestPan.getPanier();
    console.log(this.pan);
  }

  addToCart(item:any){
    this.gestPan.addPanier(item);
  }

}
