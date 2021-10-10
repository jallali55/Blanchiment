package com.gestion.blanchiment.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("P")
public class PersonnePhysique extends Tier{
	

	
	private String nom ;
	private String prenom;
	private String langue;
	private String fct ;
	private String sexe;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	private String zip_code ;
	private String CIN;

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public PersonnePhysique(String cIN) {
		super();
		CIN = cIN;
	}

	public PersonnePhysique() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "PersonnePhysique [nom=" + nom + ", prenom=" + prenom + ", langue=" + langue + ", fct=" + fct + ", sexe="
				+ sexe + ", birthday=" + birthday + ", zip_code=" + zip_code + ", CIN=" + CIN + "]";
	}

	

	

}
