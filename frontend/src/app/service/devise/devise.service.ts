import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DeviseService {

  
  private host:string="http://localhost:8080/devise";


  constructor(private http:HttpClient) { }
  getAll(){
    return this.http.get(this.host+"/")     
   }

   convert(from,to,quantite){
     return this.http.get(this.host+"/currency-converter/from/"+from+"/to/"+to+"/quantite/"+quantite)
   }
}
