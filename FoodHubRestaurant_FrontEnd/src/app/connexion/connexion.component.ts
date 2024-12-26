import {Component} from '@angular/core';

import {Router} from '@angular/router';
import {GestionService} from '../gestion.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrl: './connexion.component.css'
})

export class ConnexionComponent {
  loggedIn: boolean=false;
  response : any = {"token":""}
  constructor(private gest:GestionService, private router: Router) { }

  login(request:any){
    this.gest.connexion(request).subscribe({
      next : data => {
        console.log(data.body);
        let body:any=data.body;
        this.response.token=body.token;
        localStorage.setItem("token",body.token);
        this.gest.savetoken(this.response.token);
        this.router.navigateByUrl('/restaurants');
      }
    })
  }


}
