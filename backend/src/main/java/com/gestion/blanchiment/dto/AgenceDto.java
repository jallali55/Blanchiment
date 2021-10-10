package com.gestion.blanchiment.dto;

public class AgenceDto {
	private Integer id_pays;
	private String liblon;
	private String libcou;
	private String adresse;
	private String code_interne;
	
	public Integer getId_pays() {
		return id_pays;
	}
	public void setId_pays(Integer id_pays) {
		this.id_pays = id_pays;
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
	public AgenceDto(Integer id_pays, String liblon, String libcou, String adresse, String code_interne) {
		super();
		this.id_pays = id_pays;
		this.liblon = liblon;
		this.libcou = libcou;
		this.adresse = adresse;
		this.code_interne = code_interne;
	}
	
	
}
