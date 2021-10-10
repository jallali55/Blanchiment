import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CompteDto } from '../../Model/comptedto';

@Injectable({
  providedIn: 'root'
})
export class CompteService {

  private host:string="http://localhost:8080/compte";


  constructor(private http:HttpClient) { }
  getAll(){
    return this.http.get(this.host+"/")     
   }

   getValid(){
    return this.http.get(this.host+"/valid")     
   }
   save(data:CompteDto){
    return this.http.post(this.host+"/",data); 
   }
   enable(id){
    return this.http.get(this.host+"/enable/"+id)     
   }
   disable(id){
    return this.http.get(this.host+"/disable/"+id)     
   }
}
