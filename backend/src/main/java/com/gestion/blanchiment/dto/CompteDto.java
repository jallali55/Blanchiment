package com.gestion.blanchiment.dto;





import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.gestion.blanchiment.enums.StatutCompte;
import com.gestion.blanchiment.enums.TypeCpt;

public class CompteDto {
	private Integer id;
	private long numcpt;
	@Enumerated(EnumType.STRING)
	private TypeCpt typecompte;
	@Enumerated(EnumType.STRING)
	private StatutCompte statut;
	
	private Date date_ouverture;
	private String Rib;
	private Double solde;
	
	private Integer id_agence;
	private Integer id_tier;
	private Integer id_devise;
	private Integer id_pays;

	public long getNumcpt() {
		return numcpt;
	}
	public void setNumcpt(long numcpt) {
		this.numcpt = numcpt;
	}
	public TypeCpt getTypecompte() {
		return typecompte;
	}
	public void setTypecompte(TypeCpt typecompte) {
		this.typecompte = typecompte;
	}
	

	public Integer getId_tier() {
		return id_tier;
	}
	public void setId_tier(Integer id_tier) {
		this.id_tier = id_tier;
	}
	public Integer getId_devise() {
		return id_devise;
	}
	public void setId_devise(Integer id_devise) {
		this.id_devise = id_devise;
	}
	public String getRib() {
		return Rib;
	}
	public void setRib(String rib) {
		Rib = rib;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	public Integer getId_agence() {
		return id_agence;
	}
	public void setId_agence(Integer id_agence) {
		this.id_agence = id_agence;
	}
	public StatutCompte getStatut() {
		return statut;
	}
	public void setStatut(StatutCompte statut) {
		this.statut = statut;
	}
	public Date getDate_ouverture() {
		return date_ouverture;
	}
	public void setDate_ouverture(Date date_ouverture) {
		this.date_ouverture = date_ouverture;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_pays() {
		return id_pays;
	}
	public void setId_pays(Integer id_pays) {
		this.id_pays = id_pays;
	}

	
	

}
