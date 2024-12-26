import {Injectable} from "@angular/core";
import {
  CanActivate,
  Router
} from "@angular/router";


@Injectable()
export class AuthGuard implements CanActivate {

  constructor( private router: Router) { }

  canActivate():boolean {
    let token:any = localStorage.getItem("token");
    if(token){
      return true;
    }else{
      this.router.navigateByUrl("/login");
      return false;
    }
  }


}
