package com.gestion.blanchiment.dto;

import java.util.Date;



public class PersonnePhysiqueDto {
	private Integer id_pays;
	private String tel ;
	private String mobile ;
	private String email ;
	private String fax ;
	private String nom ;
	private String prenom;
	private String langue;
	private String fct ;
	private String sexe;
	private Date birthday;
	private String zip_code ;
	private String CIN;
	public Integer getId_pays() {
		return id_pays;
	}
	public void setId_pays(Integer id_pays) {
		this.id_pays = id_pays;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getFct() {
		return fct;
	}
	public void setFct(String fct) {
		this.fct = fct;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public PersonnePhysiqueDto(Integer id_pays, String tel, String mobile, String email, String fax, String nom,
			String prenom, String langue, String fct, String sexe, Date birthday, String zip_code, String cIN) {
		super();
		this.id_pays = id_pays;
		this.tel = tel;
		this.mobile = mobile;
		this.email = email;
		this.fax = fax;
		this.nom = nom;
		this.prenom = prenom;
		this.langue = langue;
		this.fct = fct;
		this.sexe = sexe;
		this.birthday = birthday;
		this.zip_code = zip_code;
		CIN = cIN;
	}
	public PersonnePhysiqueDto() {
		super();
	}
	
	



	
}
