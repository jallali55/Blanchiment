package com.gestion.blanchiment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.blanchiment.dto.DeviseDto;
import com.gestion.blanchiment.entities.Devise;
import com.gestion.blanchiment.repos.DeviseRepository;
import com.gestion.blanchiment.service.DeviseService;

@Service
public class DeviseServiceImpl implements DeviseService {
	@Autowired
	DeviseRepository deviseRepository;
	
	@Override
	public Devise postDevise(DeviseDto deviseDto) {
return null;
	}

	@Override
	public Devise getDeviseById(Integer id) {
		do {
			return deviseRepository.findById(id).get();
		}while(deviseRepository.findById(id).isPresent());
		
	}

	@Override
	public List<Devise> getAllDevises() {
		// TODO Auto-generated method stub
		return deviseRepository.findAll();
	}

	@Override
	public void deleteDeviseById(Integer id) {
		do {
			 deviseRepository.deleteById(id);;
		}while(deviseRepository.findById(id).isPresent());
		
		
	}

	@Override
	public void deleteAllDevises() {
		deviseRepository.deleteAll();
		
	}

}
