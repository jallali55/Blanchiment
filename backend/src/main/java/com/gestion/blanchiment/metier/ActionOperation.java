package com.gestion.blanchiment.metier;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gestion.blanchiment.repos.CompteRepository;
import com.gestion.blanchiment.repos.OperationRepository;


import com.gestion.blanchiment.entities.Compte;
import com.gestion.blanchiment.entities.Versement;
import com.gestion.blanchiment.entities.Retrait;
@Service
public class ActionOperation {
	@Autowired
	private CompteRepository CR;
	@Autowired
	private OperationRepository OR;
	
	
	public void verser(String numcpt, Double montant) {
		
		  Compte cp = CR.findByNumcpt(numcpt); Versement v = new Versement( new Date(),
		  montant, cp); OR.save(v); cp.setSolde(cp.getSolde()+montant);
		  CR.save(cp);
		 
	}

	
	
	public void retirer(String numcpt, Double montant) {
		Compte cp= CR.findByNumcpt(numcpt);
		if (cp.getSolde()<montant)throw new RuntimeException("solde insuffisant");
		Retrait r=new Retrait( new Date(),montant, cp);
		OR.save(r);
		cp.setSolde(cp.getSolde()-montant);
		CR.save(cp);}
}
