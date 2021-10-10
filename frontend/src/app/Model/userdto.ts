export class UserDto{

    private email :string;
     private firstName :string;
     private lastName :string;
     private phoneNumber:number;
     private authority:number;
     private isenabled:boolean;
  private username :string;
  private password :string;
  
    public constructor(email:string,firstName:string,lastName:string,phoneNumber:number,authority:number,isenabled:boolean,username :string,passowrd :string){
        this.email=email
        this.firstName=firstName
        this.lastName=lastName
        this.phoneNumber=phoneNumber
        this.authority=authority
        this.isenabled=isenabled
        this.password=passowrd
        this.username=username
      
    }
  }