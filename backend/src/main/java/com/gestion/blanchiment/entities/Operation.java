package com.gestion.blanchiment.entities;


import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType = DiscriminatorType.STRING,length = 100)
public abstract class Operation  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date date_operation;
	private Double montant;
	private Double soldeBefore;
	private Double soldeAfter;
	
	@ManyToOne
	private Compte compte;


	
	 
	 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDate_operation() {
		return date_operation;
	}
	public void setDate_operation(Date date_operation) {
		this.date_operation = date_operation;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	public Operation(Date date_operation, Double montant, Compte compte) {
		super();
		this.date_operation = date_operation;
		this.montant = montant;
		this.compte = compte;
	}
	public Operation() {
		super();
	}
	public Double getSoldeBefore() {
		return soldeBefore;
	}
	public void setSoldeBefore(Double soldeBefore) {
		this.soldeBefore = soldeBefore;
	}
	public Double getSoldeAfter() {
		return soldeAfter;
	}
	public void setSoldeAfter(Double soldeAfter) {
		this.soldeAfter = soldeAfter;
	}
	
	
	
	
	
	}
