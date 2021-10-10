import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private host:string="http://localhost:8080/users";


  constructor(private http:HttpClient) { }
  getAll(){
    return this.http.get(this.host+"/")     
   }

   get(id){
    return this.http.get(this.host+"/getuser/"+id)     
   }
   enable(id){
    return this.http.get(this.host+"/enable/"+id)     
   }
   disable(id){
    return this.http.get(this.host+"/disable/"+id)     
   }
   save(user){
    return this.http.post(this.host+"/register",user); 
   }
   edit(id,user){
    return this.http.post(this.host+"/update/"+id,user); 
   }
   getStat(){
    return this.http.get(this.host+"/stat/")     
   }
}
