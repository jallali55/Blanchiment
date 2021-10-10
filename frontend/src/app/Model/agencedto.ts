export class AgenceDto{

    private libcou :string;
     private liblon :string;
     private adresse :string;
     private id_pays:number;
     private code_interne:string;

  
    public constructor(libcou:string,liblon:string,adresse:string,code_interne:string,id_pays:number){
     this.libcou=libcou
     this.liblon=liblon
     this.adresse=adresse
     this.code_interne=code_interne
     this.id_pays=id_pays    
    }
  }