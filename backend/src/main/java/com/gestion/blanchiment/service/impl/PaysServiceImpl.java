package com.gestion.blanchiment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestion.blanchiment.dto.PaysDto;
import com.gestion.blanchiment.entities.Pays;
import com.gestion.blanchiment.entities.User;
import com.gestion.blanchiment.repos.PaysRepository;
import com.gestion.blanchiment.service.PaysService;
import com.gestion.blanchiment.service.ResponseService;

@Service
public class PaysServiceImpl implements PaysService{
	@Autowired
	PaysRepository paysRepository;
	  @Autowired
	    private ResponseService responseService;

	@Override
	public Pays postPays(PaysDto paysDto) {
		Pays pays=new Pays();
		if(paysDto.getId()!=null) {
			if(paysRepository.findById(paysDto.getId()).isPresent()) {
				pays=paysRepository.findById(paysDto.getId()).get();
			}
		}
		
		
		pays.setNom(paysDto.getNom());
		return paysRepository.save(pays);
	}
	@Override
	public Pays getPaysById(Integer id) {
		
		do {
			return paysRepository.findById(id).get();
		}while(paysRepository.findById(id).isPresent());
			}

	@Override
	public List<Pays> getAllPayss() {
		// TODO Auto-generated method stub
		return paysRepository.findAll();
	}

	@Override
	public void deletePaysById(Integer id) {
		do {
			paysRepository.deleteById(id);
		}while(paysRepository.findById(id).isPresent());
		
		
	}

	@Override
	public void deleteAllPayss() {
		paysRepository.deleteAll();
		
	}
	@Override
	public ResponseEntity<Object> douteux(int id) {
		Pays pays=paysRepository.findById(id).get();
		pays.setDouteux(true);
		Pays savedUser=paysRepository.save(pays);
        return responseService.getResponse(1, "Pays Updated", savedUser);
	}
	@Override
	public ResponseEntity<Object> nondouteux(int id) {
		Pays pays=paysRepository.findById(id).get();
		pays.setDouteux(false);
		Pays savedUser=paysRepository.save(pays);
        return responseService.getResponse(1, "Pays Updated", savedUser);
	}

	

}
