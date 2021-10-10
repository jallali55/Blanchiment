import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AgenceDto } from '../../Model/agencedto';

@Injectable({
  providedIn: 'root'
})
export class AgenceService {

  private host:string="http://localhost:8080/agence";


  constructor(private http:HttpClient) { }
  getAll(){
    return this.http.get(this.host+"/")     
   }

   save(data:AgenceDto){
    return this.http.post(this.host+"/",data); 
   }
}
