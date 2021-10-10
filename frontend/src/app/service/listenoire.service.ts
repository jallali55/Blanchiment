import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListenoireService {
  private host:string="http://localhost:8080/clientsuspect";
  constructor( private http:HttpClient) {
   }
   getListeNoires(){
    return this.http.get(this.host+"/")     
   }
   getFiles(){
    return this.http.get(this.host+"/getfiles")     
   }
   pushFileToStorage(file: File) {
    const data: FormData = new FormData();
    data.append('file', file);
    return this.http.post(this.host+"/files/",data)   
    }
 
}
