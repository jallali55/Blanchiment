package com.gestion.blanchiment.service.impl;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.blanchiment.dto.PersonneMoraleDto;
import com.gestion.blanchiment.entities.PersonneMorale;
import com.gestion.blanchiment.entities.PersonnePhysique;
import com.gestion.blanchiment.repos.PaysRepository;
import com.gestion.blanchiment.repos.PersonneMoraleRepository;
import com.gestion.blanchiment.service.PersonneMoraleService;

@Service
public class PersonneMoraleServiceImpl implements PersonneMoraleService {
	@Autowired
	PersonneMoraleRepository personneMoraleRepository;
	@Autowired
	PaysRepository paysRepository;
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public PersonneMorale postPersonneMorale(PersonneMoraleDto personneMoraleDto) {
		if(personneMoraleRepository.findByNumeroFiscal(personneMoraleDto.getNumeroFiscal())!=null) throw new RuntimeException("This Numero fisacale already exist");

		PersonneMorale personneMorale=modelmapper.map(personneMoraleDto, PersonneMorale.class);
		personneMorale.setPays(paysRepository.findById(personneMoraleDto.getId_pays()).get());	
		PersonneMorale saved= personneMoraleRepository.save(personneMorale);
		  return personneMoraleRepository.findById(saved.getId()).get();
		  

		 
	}

	@Override
	public PersonneMorale getPersonneMoraleById(Integer id) {
		
		do {
			return personneMoraleRepository.findById(id).get();
			}
			while (personneMoraleRepository.findById(id).isPresent());

	}

	@Override
	public List<PersonneMorale> getAllPersonneMorale() {
		
		return personneMoraleRepository.findAll();
	}

	@Override
	public void DeletePersonneMoraleById(Integer id) {
		do {
			personneMoraleRepository.deleteById(id);
			}
			while (personneMoraleRepository.findById(id).isPresent());
		
	}

	@Override
	public void DeleteAllPersonneMorale() {
		personneMoraleRepository.deleteAll();
		
	}

	@Override
	public PersonneMorale update(int id, PersonneMoraleDto personneMoraleDto) {
		PersonneMorale personneMorale=modelmapper.map(personneMoraleDto, PersonneMorale.class);
		personneMorale.setPays(paysRepository.findById(personneMoraleDto.getId_pays()).get());	
		personneMorale.setId(id);
		PersonneMorale saved= personneMoraleRepository.save(personneMorale);
		  return personneMoraleRepository.findById(saved.getId()).get();
	}

}
