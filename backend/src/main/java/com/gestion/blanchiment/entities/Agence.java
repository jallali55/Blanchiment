package com.gestion.blanchiment.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity@Table
public class Agence {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String liblon;
	private String libcou;
	private String adresse;
	private String code_interne;
	@ManyToOne
	private Pays pays;
	
	@OneToMany(mappedBy = "agence")
	@JsonIgnore
	private List<Compte> comptes;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLiblon() {
		return liblon;
	}
	public void setLiblon(String liblon) {
		this.liblon = liblon;
	}
	public String getLibcou() {
		return libcou;
	}
	public void setLibcou(String libcou) {
		this.libcou = libcou;
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCode_interne() {
		return code_interne;
	}
	public void setCode_interne(String code_interne) {
		this.code_interne = code_interne;
	}
	public Agence(Integer id, String liblon, String libcou, String adresse, String code_interne,
			List<Compte> comptes) {
		super();
		this.id = id;
		this.liblon = liblon;
		this.libcou = libcou;
		this.adresse = adresse;
		this.code_interne = code_interne;
		
		this.comptes = comptes;
	}
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}

	
	
	

}
