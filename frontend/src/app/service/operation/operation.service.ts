import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OperationDto } from '../../Model/OerationDto';

@Injectable({
  providedIn: 'root'
})
export class OperationService {

  private host:string="http://localhost:8080/operation";


  constructor(private http:HttpClient) { }
  getAll(){
    return this.http.get(this.host+"/")     
   }
   save(data:OperationDto){
    return this.http.post(this.host+"/",data); 
   }
}
