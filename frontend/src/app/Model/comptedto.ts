export class CompteDto {
    private numcpt : number;
	private typecompte : string;
	private rib : string;
	private solde : number;	
	private  id_agence:number;
    private  id_tier:number;
    private  id_devise:number;
    private statut:string;
    private date_ouverture:Date;
    
    constructor( numcpt : number, typecompte : string, Rib : string, solde : number,  id_agence:number,
        id_tier:number,id_devise:number,statut:string,date_ouverture:Date) {
            this.numcpt=numcpt;
            this.typecompte=typecompte;
            this.rib=Rib;
            this.solde=solde;
            this.id_agence=id_agence;
            this.id_tier=id_tier;
            this.id_devise=id_devise;
            this.statut=statut;
            this.date_ouverture=date_ouverture;

    }

 }