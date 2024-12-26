import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GestionService {

  constructor(private http: HttpClient) { }

  getAllRestaurants(){
    return this.http.get('http://localhost:14000/api/restaurant/liste');
  }
  getAllMenusByRestaurantId(rest_id:number){
    return this.http.get('http://localhost:14000/api/restaurant/menu/'+rest_id);
  }
  getRestaurant(id:number){
    return this.http.get(`http://localhost:14000/api/restaurant/${id}`);
  }

}
