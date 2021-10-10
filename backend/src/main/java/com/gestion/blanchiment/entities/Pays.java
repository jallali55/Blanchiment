package com.gestion.blanchiment.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pays {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private Boolean douteux;
	private int phonecode;
	private String iso;
	@OneToMany(mappedBy = "pays")
	@JsonIgnore
	private List<Tier> tiers;
	
	@OneToMany(mappedBy = "pays")
	@JsonIgnore
	private List<Agence> agences;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<Tier> getTiers() {
		return tiers;
	}

	public void setTiers(List<Tier> tiers) {
		this.tiers = tiers;
	}

	

	public Pays() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boolean getDouteux() {
		return douteux;
	}

	public void setDouteux(Boolean douteux) {
		this.douteux = douteux;
	}

	public int getPhonecode() {
		return phonecode;
	}

	public void setPhonecode(int phonecode) {
		this.phonecode = phonecode;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public List<Agence> getAgences() {
		return agences;
	}

	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}


	

}
