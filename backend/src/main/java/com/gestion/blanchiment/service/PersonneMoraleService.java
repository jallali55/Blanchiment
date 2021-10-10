package com.gestion.blanchiment.service;

import java.util.List;

import com.gestion.blanchiment.dto.PersonneMoraleDto;
import com.gestion.blanchiment.dto.PersonnePhysiqueDto;
import com.gestion.blanchiment.entities.PersonneMorale;
import com.gestion.blanchiment.entities.PersonnePhysique;

public interface PersonneMoraleService {
	public PersonneMorale postPersonneMorale(PersonneMoraleDto personneMorale);
	public PersonneMorale getPersonneMoraleById (Integer id);
	public List<PersonneMorale> getAllPersonneMorale ();
	public void DeletePersonneMoraleById(Integer id);
	public void DeleteAllPersonneMorale();
    public PersonneMorale update(int id,PersonneMoraleDto personneMoraleDto);

	}
