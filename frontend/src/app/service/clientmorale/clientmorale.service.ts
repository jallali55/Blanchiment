import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { id } from '@swimlane/ngx-charts';
import { ClientmoraleDto } from '../../Model/clientmoraledto';

@Injectable({
  providedIn: 'root'
})
export class ClientmoraleService {

  private host:string="http://localhost:8080/personnemorale";


  constructor(private http:HttpClient) { }
  getAll(){
    return this.http.get(this.host+"/")     
   }
   save(data:ClientmoraleDto){
    return this.http.post(this.host+"/",data); 
   }
   get(id){
    return this.http.get(this.host+"/"+id)     
   }
   edit(id,per){
    return this.http.post(this.host+"/update/"+id,per); 
   }
  
}
