package com.gestion.blanchiment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gestion.blanchiment.dto.CompteDto;
import com.gestion.blanchiment.entities.Compte;

public interface CompteService {
	public Compte postCompte(CompteDto compte);
	public Compte getCompteById(Integer id);
	public List<Compte> getAllComptes();
	public Compte getCompteByNumCpt(String numcpt);
	
	public void deleteCompteById(Integer id);
	public void deleteAllComptes();
	public List<Compte> getValid();
	public ResponseEntity<Object> enable(int compteId);
    public ResponseEntity<Object> disable(int compteId);

}
