import { ThrowStmt } from "@angular/compiler";

export class ClientmoraleDto{
    private id_pays:number
	private email : string;
    private fax : string;
    private mobile : string;
    private tel : string;
    private  raisonSocial:string;
	private numeroFiscal:string;
	private numeroDocumentFiscal:string;
	private formeJuridique :string;
	private raisonEconomique :string;
    
		
    public constructor(id_pays:number,email:string,fax : string,mobile : string,tel : string,
        raisonSocial:string,numeroFiscal:string,numeroDocumentFiscal:string,formeJuridique :string,raisonEconomique :string){
        this.id_pays=id_pays
        this.email=email
        this.fax=fax
        this.mobile=mobile
        this.tel=tel
        this.raisonSocial=raisonSocial
        this.numeroFiscal=numeroFiscal
        this.numeroDocumentFiscal=numeroDocumentFiscal
        this.formeJuridique=formeJuridique
        this.raisonEconomique=raisonEconomique
    }
}