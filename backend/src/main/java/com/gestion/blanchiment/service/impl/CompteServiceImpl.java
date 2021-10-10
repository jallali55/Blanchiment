package com.gestion.blanchiment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestion.blanchiment.dto.CompteDto;
import com.gestion.blanchiment.entities.ClientSuspect;
import com.gestion.blanchiment.entities.Compte;
import com.gestion.blanchiment.entities.PersonneMorale;
import com.gestion.blanchiment.entities.PersonnePhysique;
import com.gestion.blanchiment.entities.User;
import com.gestion.blanchiment.enums.StatutCompte;
import com.gestion.blanchiment.repos.AgenceRepository;
import com.gestion.blanchiment.repos.ClientSuspectRepository;
import com.gestion.blanchiment.repos.CompteRepository;
import com.gestion.blanchiment.repos.DeviseRepository;
import com.gestion.blanchiment.repos.PaysRepository;
import com.gestion.blanchiment.repos.TierRepository;
import com.gestion.blanchiment.service.CompteService;
import com.gestion.blanchiment.service.ResponseService;

@Service
public class CompteServiceImpl implements CompteService {
	@Autowired
	CompteRepository compterepository;
	@Autowired
	AgenceRepository agenceRepository;
	@Autowired
	DeviseRepository deviseRepository;
	@Autowired
	TierRepository tierRepository;
	@Autowired
	ModelMapper modelMapper;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private ClientSuspectRepository clientSuspectRepository;
	@Override
	public Compte postCompte(CompteDto compte) {
		if(compterepository.findByNumcpt(compte.getNumcpt())!=null) throw new RuntimeException("This num compte already exist");
		Compte cpt=modelMapper.map(compte, Compte.class);
		cpt.setTier(tierRepository.findById(compte.getId_tier()).get());
		cpt.setDevise(deviseRepository.findById(compte.getId_devise()).get());
		cpt.setAgence(agenceRepository.findById(compte.getId_agence()).get());
		return compterepository.save(cpt);
	}

	@Override
	public Compte getCompteById(Integer id) {
		
		do {
			return compterepository.findById(id).get();
		}while(compterepository.findById(id).isPresent());
		
	}

	@Override
	public List<Compte> getAllComptes() {
		return compterepository.findAll();
	}


	@Override
	public void deleteCompteById(Integer id) {
		do {
			 compterepository.deleteById(id);
		}while(compterepository.findById(id).isPresent());
		
	}

	@Override
	public void deleteAllComptes() {
		compterepository.deleteAll();
		
	}

	@Override
	public List<Compte> getValid() {
		List <ClientSuspect> clientSuspects=clientSuspectRepository.findAll();
		List<Compte> res=new ArrayList<Compte>();
		for (Compte compte : compterepository.findAll()){
			if(!compte.getAgence().getPays().getDouteux()&&compte.getStatut().equals(StatutCompte.actif)) {
				String cin="0";
				String numFiscale="";
				Boolean valid=true;
				if(compte.getTier().getClass().equals(PersonnePhysique.class)) {
					PersonnePhysique p=(PersonnePhysique) compte.getTier();
					cin=p.getCIN();
				}
				else {
					PersonneMorale p=(PersonneMorale) compte.getTier();
					numFiscale=p.getNumeroFiscal();
				}
				System.out.println(compte.getTier().getClass());
				for (ClientSuspect client : clientSuspects) {
					if(client.getNumeroFiscal().equals(numFiscale)||Double.valueOf(client.getCin()).equals(Double.valueOf(cin))) {
						if(client.getNiveau_risque().equals("Elevé")) {
							valid=false;
						}
					}
				}
				if(valid) {
					res.add(compte);
				}
			}
		}
		return res;
	}

	@Override
	public ResponseEntity<Object> enable(int compteId) {
		Compte compte=compterepository.findById(compteId).get();
		compte.setStatut(StatutCompte.actif);
		Compte savedcompte=compterepository.save(compte);
        return responseService.getResponse(1, "Compte Updated", savedcompte);
	}

	@Override
	public ResponseEntity<Object> disable(int compteId) {
		Compte compte=compterepository.findById(compteId).get();
		compte.setStatut(StatutCompte.inactif);
		Compte savedcompte=compterepository.save(compte);
        return responseService.getResponse(1, "Compte Updated", savedcompte);
	}

	@Override
	public Compte getCompteByNumCpt(String numcpt) {
		// TODO Auto-generated method stub
		return null;
	}

}
