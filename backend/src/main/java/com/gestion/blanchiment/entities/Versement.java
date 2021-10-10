package com.gestion.blanchiment.entities;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity@DiscriminatorValue("V")
public class Versement extends Operation{

	public Versement(Date date_operation, Double montant, Compte compte) {
		super(date_operation, montant, compte);
		// TODO Auto-generated constructor stub
	}

	public Versement() {
		super();
	}

	

	
	
	

}
