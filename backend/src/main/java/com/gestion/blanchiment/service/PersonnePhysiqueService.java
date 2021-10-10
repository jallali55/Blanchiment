package com.gestion.blanchiment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gestion.blanchiment.dto.PersonnePhysiqueDto;
import com.gestion.blanchiment.entities.PersonnePhysique;

public interface PersonnePhysiqueService {
	public PersonnePhysique postPersonnePhysique(PersonnePhysiqueDto personnePhysiqueDto);
	public PersonnePhysique getPersonnePhysiqueById (Integer id);
	public List<PersonnePhysique> getAllPersonnePhysique ();
	public void DeletePersonnePhysiqueById(Integer id);
	public void DeleteAllPersonnePhysique();
    public PersonnePhysique update(int id,PersonnePhysiqueDto personnePhysiqueDto);

}
