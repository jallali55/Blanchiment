package com.gestion.blanchiment.service;
import java.util.List;

import com.gestion.blanchiment.dto.AgenceDto;
import com.gestion.blanchiment.entities.Agence;


public interface AgenceService {
	
	public Agence postAgence(AgenceDto agenceDto);
	public Agence getAgenceById(Integer id);
	public List<Agence> getAllAgences();
	public List<Agence> getAgenceByAdresse(String adresse);
	public List<Agence> getAgenceByLiblon(String liblon);
	public List<Agence> getAgenceByLibcou(String libcou);
	public void deleteAgenceById(Integer id);
	public void deleteAllAgences();

}
