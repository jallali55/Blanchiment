

export class ClientphysiqueDto {
    private id_pays:number
	private email : string;
    private fax : string;
    private mobile : string;
    private tel : string;
	
    private cin : string;
    private fct : String;	
	private  nom:string;
    private prenom : String;
	private langue : string;
	private sexe : string;	
	private  birthday:Date;
    private zip_code : string;
       
    public constructor(id_pays:number,email:string,fax : string,mobile : string,tel : string,
        cin:string,fct:string,nom:string,prenom :string,langue :string,
        sexe:string,birthday:Date,zip_code:string){
        this.id_pays=id_pays
        this.email=email
        this.fax=fax
        this.mobile=mobile
        this.tel=tel
        this.cin=cin
        this.fct=fct
        this.nom=nom
        this.prenom=prenom
        this.langue=langue
        this.sexe=sexe
        this.birthday=birthday
        this.zip_code=zip_code
    }

 }
