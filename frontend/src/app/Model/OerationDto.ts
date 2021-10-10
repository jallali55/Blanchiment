export class OperationDto {
    private montant : number;
	private compte_id : number;
	private type : string;	
    
    constructor( montant:number,compte_id:number,type:string) {
     this.montant=montant
     this.compte_id=compte_id
     this.type=type
    }

 }