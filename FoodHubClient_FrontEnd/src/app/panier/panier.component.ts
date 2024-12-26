import { Component } from '@angular/core';
import {PanierService} from '../panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrl: './panier.component.css'
})
export class PanierComponent {
  carts: any[] = [];

  constructor(private gestPan:PanierService) {
    this.getCarts()
  }

  getCarts():void{
    this.carts=this.gestPan.getPanier();
  }

  deleteCart(item:any):void{ /// a faire
    this.carts.splice(this.carts.indexOf(item),1);
  }

}
