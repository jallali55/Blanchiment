package com.gestion.blanchiment.dto;



public class DeviseDto {
	private Integer id;
	private String nom;
	private String libcou;
	private String liblon;
	private String nom_traduit;
	
	private Integer id_compte;


	private Integer id_devisevendu;
	
	private Integer id_deviseachete;

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

	public String getLibcou() {
		return libcou;
	}

	public void setLibcou(String libcou) {
		this.libcou = libcou;
	}

	public String getLiblon() {
		return liblon;
	}

	public void setLiblon(String liblon) {
		this.liblon = liblon;
	}

	public String getNom_traduit() {
		return nom_traduit;
	}

	public void setNom_traduit(String nom_traduit) {
		this.nom_traduit = nom_traduit;
	}

	

	public Integer getId_devisevendu() {
		return id_devisevendu;
	}

	public void setId_devisevendu(Integer id_devisevendu) {
		this.id_devisevendu = id_devisevendu;
	}

	public Integer getId_deviseachete() {
		return id_deviseachete;
	}

	public void setId_deviseachete(Integer id_deviseachete) {
		this.id_deviseachete = id_deviseachete;
	}

	public DeviseDto(Integer id, String nom, String libcou, String liblon, String nom_traduit,
			Integer id_devisevendu, Integer id_deviseachete) {
		super();
		this.id = id;
		this.nom = nom;
		this.libcou = libcou;
		this.liblon = liblon;
		this.nom_traduit = nom_traduit;
	
		this.id_devisevendu = id_devisevendu;
		this.id_deviseachete = id_deviseachete;
	}

	public DeviseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_compte() {
		return id_compte;
	}

	public void setId_compte(Integer id_compte) {
		this.id_compte = id_compte;
	}

}
