package com.gestion.blanchiment.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.blanchiment.dto.OperationDto;
import com.gestion.blanchiment.entities.Compte;
import com.gestion.blanchiment.entities.Devise;
import com.gestion.blanchiment.entities.Operation;
import com.gestion.blanchiment.entities.Retrait;
import com.gestion.blanchiment.entities.Versement;
import com.gestion.blanchiment.repos.CompteRepository;
import com.gestion.blanchiment.repos.DeviseRepository;
import com.gestion.blanchiment.repos.OperationRepository;
import com.gestion.blanchiment.repos.RetraitRepository;
import com.gestion.blanchiment.repos.VersementRepository;
import com.gestion.blanchiment.service.OperationService;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private DeviseRepository deviseRepository;
	@Autowired
	private RetraitRepository retraitRepository;
	@Autowired
	private VersementRepository versementRepository;
	@Override
	public Operation postOperation(OperationDto operationDto) {
		Compte compte= compteRepository.findById(operationDto.getCompte_id()).get();
		
		if(operationDto.getType().equals("R")) {
			Retrait retrait=new Retrait();
			retrait.setMontant(operationDto.getMontant());
			retrait.setDate_operation(new Date());
			retrait.setCompte(compte);
			retrait.setSoldeBefore(compte.getSolde());
			retrait.setSoldeAfter(compte.getSolde()-operationDto.getMontant());
			compte.setSolde(retrait.getSoldeAfter());
			compteRepository.save(compte);
			return retraitRepository.save(retrait);	

		}
		else {
			Versement versement=new Versement();
			versement.setMontant(operationDto.getMontant());
			versement.setDate_operation(new Date());
			versement.setCompte(compte);
			versement.setSoldeBefore(compte.getSolde());
			versement.setSoldeAfter(compte.getSolde()+operationDto.getMontant());
			compte.setSolde(versement.getSoldeAfter());
			compteRepository.save(compte);
			return 	versementRepository.save(versement);

		}
		
	}

	
}
