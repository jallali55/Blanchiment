package com.gestion.blanchiment.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestion.blanchiment.dto.PersonnePhysiqueDto;
import com.gestion.blanchiment.entities.PersonnePhysique;
import com.gestion.blanchiment.repos.CompteRepository;
import com.gestion.blanchiment.repos.PaysRepository;
import com.gestion.blanchiment.repos.PersonnePhysiqueRepository;
import com.gestion.blanchiment.service.PersonnePhysiqueService;

@Service
public class PersonnePhysiqueServiceImpl implements PersonnePhysiqueService{
	@Autowired
	PersonnePhysiqueRepository personnePhysiqueRepository;
	@Autowired
	private PaysRepository paysRepository;
	@Autowired
	private ModelMapper modelmapper;
	@Override
	public PersonnePhysique postPersonnePhysique(PersonnePhysiqueDto personnePhysiqueDto) {
		if(personnePhysiqueRepository.findByCIN(personnePhysiqueDto.getCIN())!=null) throw new RuntimeException("This cin already exist");

		PersonnePhysique personnePhysique=modelmapper.map(personnePhysiqueDto, PersonnePhysique.class);
		  personnePhysique.setPays(paysRepository.findById(personnePhysiqueDto.getId_pays()).get());	
		  PersonnePhysique saved= personnePhysiqueRepository.save(personnePhysique);
		  return personnePhysiqueRepository.findById(saved.getId()).get();		  
	}

	@Override
	public PersonnePhysique getPersonnePhysiqueById(Integer id) {
		do {
			return personnePhysiqueRepository.findById(id).get();
			}
			while (personnePhysiqueRepository.findById(id).isPresent());

	}

	@Override
	public List<PersonnePhysique> getAllPersonnePhysique() {
		
		return personnePhysiqueRepository.findAll();
	}

	@Override
	public void DeletePersonnePhysiqueById(Integer id) {
		do {
			personnePhysiqueRepository.deleteById(id);
			}
			while (personnePhysiqueRepository.findById(id).isPresent());		
	}

	@Override
	public void DeleteAllPersonnePhysique() {
		personnePhysiqueRepository.deleteAll();
		
	}

	@Override
	public PersonnePhysique update(int id, PersonnePhysiqueDto personnePhysiqueDto) {
		PersonnePhysique personnePhysique=modelmapper.map(personnePhysiqueDto, PersonnePhysique.class);
		  personnePhysique.setPays(paysRepository.findById(personnePhysiqueDto.getId_pays()).get());	
		  personnePhysique.setId(id);
		  PersonnePhysique saved= personnePhysiqueRepository.save(personnePhysique);
		  return personnePhysiqueRepository.findById(saved.getId()).get();	
	}

}
