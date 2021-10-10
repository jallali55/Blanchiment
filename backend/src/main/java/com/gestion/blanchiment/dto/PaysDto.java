package com.gestion.blanchiment.dto;

public class PaysDto {
	private Integer id;
	private String nom;
	private String code_tel;
	private String liblon;
	private String libcou;
	private Boolean douteux;
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
	public String getCode_tel() {
		return code_tel;
	}
	public void setCode_tel(String code_tel) {
		this.code_tel = code_tel;
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
	public Boolean getDouteux() {
		return douteux;
	}
	public void setDouteux(Boolean douteux) {
		this.douteux = douteux;
	}
	public PaysDto(Integer id, String nom, String code_tel, String liblon, String libcou, Boolean douteux) {
		super();
		this.id = id;
		this.nom = nom;
		this.code_tel = code_tel;
		this.liblon = liblon;
		this.libcou = libcou;
		this.douteux = douteux;
	}
	public PaysDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
