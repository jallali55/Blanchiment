package com.gestion.blanchiment.dto;

import java.util.Date;


public class RetraitDto {
	
	
	private Double montant;
	private Integer id_compte;
	
	private Integer id_devise;


	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Integer getId_compte() {
		return id_compte;
	}

	public void setId_compte(Integer id_compte) {
		this.id_compte = id_compte;
	}

	public Integer getId_devise() {
		return id_devise;
	}

	public void setId_devise(Integer id_devise) {
		this.id_devise = id_devise;
	}

	

}
