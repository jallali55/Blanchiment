package com.gestion.blanchiment.dto;



public class OperationDto {
	private Double montant;
	private int compte_id;
	private String type;
	
	
public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
public Double getMontant() {
	return montant;
}
public void setMontant(Double montant) {
	this.montant = montant;
}
public int getCompte_id() {
	return compte_id;
}
public void setCompte_id(int compte_id) {
	this.compte_id = compte_id;
}


}
