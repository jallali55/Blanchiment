package com.gestion.blanchiment.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table
public class ClientSuspect {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Niveau_risque;
	private Date Date_insertion;
	private String cin;
	private String numeroFiscal;


	public String getNiveau_risque() {
		return Niveau_risque;
	}

	public void setNiveau_risque(String Niveau_risque) {
		this.Niveau_risque = Niveau_risque;
	}

	public Date getDate_insertion() {
		return Date_insertion;
	}

	public void setDate_insertion(Date date_insertion) {
		this.Date_insertion = date_insertion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClientSuspect(Integer id, String Niveau_risque, Date date_insertion) {
		super();
		this.id = id;
		this.Niveau_risque = Niveau_risque;
		this.Date_insertion = date_insertion;

	}

	public ClientSuspect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNumeroFiscal() {
		return numeroFiscal;
	}

	public void setNumeroFiscal(String numeroFiscal) {
		this.numeroFiscal = numeroFiscal;
	}
	
	

}
