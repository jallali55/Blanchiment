package com.gestion.blanchiment.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class PersonneMorale extends Tier {
	
	private String raisonSocial;
	private String numeroFiscal;
	private String numeroDocumentFiscal;
	private String formeJuridique;
	private String raisonEconomique;
		



	public String getRaisonSocial() {
		return raisonSocial;
	}




	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}




	public String getNumeroFiscal() {
		return numeroFiscal;
	}




	public void setNumeroFiscal(String numeroFiscal) {
		this.numeroFiscal = numeroFiscal;
	}




	public String getNumeroDocumentFiscal() {
		return numeroDocumentFiscal;
	}




	public void setNumeroDocumentFiscal(String numeroDocumentFiscal) {
		this.numeroDocumentFiscal = numeroDocumentFiscal;
	}




	public String getFormeJuridique() {
		return formeJuridique;
	}




	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}




	public String getRaisonEconomique() {
		return raisonEconomique;
	}




	public void setRaisonEconomique(String raisonEconomique) {
		this.raisonEconomique = raisonEconomique;
	}




	public PersonneMorale(String raisonSocial, String numeroFiscal, String numeroDocumentFiscal, String formeJuridique,
			String raisonEconomique) {
		super();
		this.raisonSocial = raisonSocial;
		this.numeroFiscal = numeroFiscal;
		this.numeroDocumentFiscal = numeroDocumentFiscal;
		this.formeJuridique = formeJuridique;
		this.raisonEconomique = raisonEconomique;
	}




	public PersonneMorale() {
		super();
		// TODO Auto-generated constructor stub
	}


}
