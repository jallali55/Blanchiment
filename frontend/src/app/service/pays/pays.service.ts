import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PaysService {
  private host:string="http://localhost:8080/pays";


  constructor(private http:HttpClient) { }
  getAll(){
    return this.http.get(this.host+"/")     
   }

   nondouteux(id){
    return this.http.get(this.host+"/nondouteux/"+id)     
   }
   douteux(id){
    return this.http.get(this.host+"/douteux/"+id)     
   }
  
}
