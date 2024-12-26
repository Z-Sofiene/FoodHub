import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PanierService {
  private localStorageKey = 'cart';
  constructor() { }

  // Clear the cart
  clearCart(): Observable<void> {
    localStorage.removeItem(this.localStorageKey);
    return of();
  }

  getPanier():any[]{
    let pan = localStorage.getItem('carts');
    if(pan){
      return JSON.parse(pan);
    }
    else{
      return [];
    }
  }

  addPanier(item:any){
    localStorage.setItem('carts', JSON.stringify(this.getPanier().push(item)));
  }
}
