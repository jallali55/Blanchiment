package com.gestion.blanchiment.entities;



import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity@DiscriminatorValue("R")
public class Retrait extends Operation{

	public Retrait(Date date_operation, Double montant, Compte compte) {
		super(date_operation, montant, compte);
		// TODO Auto-generated constructor stub
	}

	public Retrait() {
		super();
	}

	


	

}
