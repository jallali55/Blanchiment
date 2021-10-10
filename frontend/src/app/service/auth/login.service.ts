import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { JwtHelperService } from "@auth0/angular-jwt";
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private host:string="http://localhost:8080";
  private jwtToken=null;
  private role:string;
  private username:string;
  private helper = new JwtHelperService();
  constructor( private http:HttpClient) {

   }
   login(user){
     console.log(user);
     return this.http.post(this.host+"/login",user ,{observe:'response'}); 
   }

   logout(){
    this.jwtToken=null;
     localStorage.removeItem('token')
     localStorage.removeItem('userId')

   }
   
   saveToken(jwt : string){
    this.jwtToken=jwt;
    localStorage.setItem('token', jwt);
    this.role=this.helper.decodeToken(this.jwtToken).role;
    this.username=this.helper.decodeToken(this.jwtToken).username;
    localStorage.setItem('username', this.username);
    let parametres = new HttpParams();
    parametres = parametres.append('username', localStorage.getItem('username'));
   this.http.get(this.host+"/users/findByuserName", { params: parametres , headers:new HttpHeaders({'Authorization':this.jwtToken}) }).subscribe((data:any)=>{
    localStorage.setItem('userId', data.id);
  })
  }
  setUserinLocal(){
    let parametres = new HttpParams();
    parametres = parametres.append('username', localStorage.getItem('username'));
    return this.http.get(this.host+"/users/findByuserName", { params: parametres , headers:new HttpHeaders({'Authorization':this.jwtToken}) });
  }
   loadToken(){
     this.jwtToken=localStorage.getItem('token');
   }
    isLoginIn(){
      this.loadToken()
      if(this.jwtToken==null){
        return false;
      }
      return true;
    }
    isAdmin(){
      if(this.helper.decodeToken(localStorage.getItem("token")).role=="ADMIN"){
        return true;
      }
      return false;
    }
  
   
  }