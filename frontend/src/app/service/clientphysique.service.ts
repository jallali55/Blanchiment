import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ClientphysiqueDto } from '../Model/clientphysiquedto';

@Injectable({
  providedIn: 'root'
})
export class ClientphysiqueService {
  private host:string="http://localhost:8080/personnephysique";


  constructor(private http:HttpClient) { }
  getAll(){
    return this.http.get(this.host+"/")     
   }
   get(id){
    return this.http.get(this.host+"/"+id)     
   }
   save(data:ClientphysiqueDto){
    return this.http.post(this.host+"/",data); 
   }
   edit(id,per){
    return this.http.post(this.host+"/update/"+id,per); 
   }
}
