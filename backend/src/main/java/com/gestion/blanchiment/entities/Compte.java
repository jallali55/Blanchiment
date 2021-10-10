package com.gestion.blanchiment.entities;


import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.blanchiment.enums.StatutCompte;
import com.gestion.blanchiment.enums.TypeCpt;


@Entity

public  class Compte {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private long numcpt;
	@Enumerated(EnumType.STRING)
	private TypeCpt typecompte;
	@Enumerated(EnumType.STRING)
	private StatutCompte statut;
	
	private Date date_ouverture;
	private String Rib;

	private Double solde;

	
	@ManyToOne
	private Agence agence;
	@ManyToOne
	
	private Tier tier;
	@ManyToOne
	private Devise devise;
	
	
	@OneToMany(mappedBy = "compte")
	@JsonIgnore
	private List<Operation> operation;
	
	
	public Devise getDevise() {
		return devise;
	}
	public void setDevise(Devise devise) {
		this.devise = devise;
	}
	public List<Operation> getOperation() {
		return operation;
	}
	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}
	
	public TypeCpt getTypecompte() {
		return typecompte;
	}
	public void setTypecompte(TypeCpt typecompte) {
		this.typecompte = typecompte;
	}
	public Tier getTier() {
		return tier;
	}
	public void setTier(Tier tier) {
		this.tier = tier;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public long getNumcpt() {
		return numcpt;
	}
	public void setNumcpt(long numcpt) {
		this.numcpt = numcpt;
	}
	public StatutCompte getStatut() {
		return statut;
	}
	public void setStatut(StatutCompte statut) {
		this.statut = statut;
	}

	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	
	public Date getDate_ouverture() {
		return date_ouverture;
	}
	public void setDate_ouverture(Date date_ouverture) {
		this.date_ouverture = date_ouverture;
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
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(Integer id, long numcpt, TypeCpt typecompte, StatutCompte statut, Date date_ouverture, String rib,
			Double solde, Agence agence, Tier tier, Devise devise, List<Operation> operation) {
		super();
		this.id = id;
		this.numcpt = numcpt;
		this.typecompte = typecompte;
		this.statut = statut;
		this.date_ouverture = date_ouverture;
		Rib = rib;
		this.solde = solde;
		this.agence = agence;
		this.tier = tier;
		this.devise = devise;
		this.operation = operation;
	}

	
	
	
	
	
}
