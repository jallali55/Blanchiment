package com.gestion.blanchiment.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.blanchiment.dto.AgenceDto;
import com.gestion.blanchiment.entities.Agence;
import com.gestion.blanchiment.repos.AgenceRepository;
import com.gestion.blanchiment.repos.PaysRepository;
import com.gestion.blanchiment.service.AgenceService;

@Service
public class AgenceServiceImpl implements AgenceService{
	
	@Autowired
	AgenceRepository agenceRepository;
	@Autowired
	PaysRepository paysRepository;
	
	@Override
	public Agence postAgence(AgenceDto agenceDto) {
		Agence ag=new Agence();
		ag.setPays(paysRepository.findById(agenceDto.getId_pays()).get());
		ag.setLiblon(agenceDto.getLiblon());
		ag.setLibcou(agenceDto.getLibcou());	
		ag.setAdresse(agenceDto.getAdresse());
		ag.setLibcou(agenceDto.getLibcou());
		ag.setCode_interne(agenceDto.getCode_interne());
		return agenceRepository.save(ag);
	}

	@Override
	public Agence getAgenceById(Integer id) {
		do {
			return agenceRepository.findById(id).get();
		}while(agenceRepository.findById(id).isPresent());
		
	}

	@Override
	public List<Agence> getAllAgences() {
		return agenceRepository.findAll();
	}

	@Override
	public void deleteAgenceById(Integer id) {
		do {
			agenceRepository.deleteById(id);
		}while(agenceRepository.findById(id).isPresent());
		
		
	}

	@Override
	public void deleteAllAgences() {
		agenceRepository.deleteAll();
		
	}

	@Override
	public List<Agence> getAgenceByAdresse(String adresse) {
	
			return agenceRepository.findByAdresse(adresse);
		
	}

	@Override
	public List<Agence> getAgenceByLiblon(String liblon) {
		return agenceRepository.findByLiblon(liblon);
	}

	@Override
	public List<Agence> getAgenceByLibcou(String libcou) {
		return agenceRepository.findByLibcou(libcou);
	}


	
	
	
}
