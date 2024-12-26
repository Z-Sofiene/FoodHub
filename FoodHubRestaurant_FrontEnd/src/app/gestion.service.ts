import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {JwtHelperService} from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class GestionService {

  username: any="";
  token: any="";
  constructor(private http: HttpClient) {}
  connexion(request: any) {
    return this.http.post("http://localhost:14000/auth/login", request, { observe: 'response' });
  }
  savetoken(token: string) {
    const hp = new JwtHelperService();
    this.token = token;
    this.username = hp.decodeToken(token).sub;
  }
  tokenizer(){
    let token:any = localStorage.getItem("token");
    return new HttpHeaders({"authorization": token});
  }
  getAllRestaurants(){
    return this.http.get('http://localhost:14000/api/restaurant/liste');
  }
  addRestaurant(image: File, restaurant:any) {
    const formData = new FormData();
    formData.append('file', image);
    formData.append('restaurant', JSON.stringify(restaurant));
    return this.http.post('http://localhost:14000/api/restaurant/add', formData, {headers: this.tokenizer()});
  }

  deleteRestaurant(rest_id:number){
    return this.http.delete("http://localhost:14000/api/restaurant/delete/"+rest_id, {headers: this.tokenizer()});
  }

  getAllMenusByRestaurantId(rest_id:number){
    return this.http.get('http://localhost:14000/api/restaurant/menu/'+rest_id);
  }
  addMenu(image: File, menu:any) {
    const formData = new FormData();
    formData.append('file', image);
    formData.append('menu', JSON.stringify(menu));
    return this.http.post("http://localhost:14000/api/menu/add", formData, {headers: this.tokenizer()});
  }

  deleteMenu(id_menu:number){
    return this.http.delete("http://localhost:14000/api/menu/delete/"+id_menu, {headers: this.tokenizer()});
  }
}
