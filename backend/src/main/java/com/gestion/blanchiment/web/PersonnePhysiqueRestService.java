package com.gestion.blanchiment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.blanchiment.dto.PersonnePhysiqueDto;
import com.gestion.blanchiment.dto.Userdto;
import com.gestion.blanchiment.entities.PersonnePhysique;
import com.gestion.blanchiment.entities.User;
import com.gestion.blanchiment.repos.PersonnePhysiqueRepository;
import com.gestion.blanchiment.service.PersonnePhysiqueService;

@RestController
public class PersonnePhysiqueRestService {
	@Autowired
	PersonnePhysiqueRepository PPR;
	@Autowired
	private PersonnePhysiqueService pps;
	
	@RequestMapping(value="/personnephysique",method = RequestMethod.GET)
	public List<PersonnePhysique> getpersonnephysique(){
		return PPR.findAll();
	}
	
	@RequestMapping(value="/personnephysique/{id}",method = RequestMethod.GET)
	public PersonnePhysique getpersonnephysiquebyid(@PathVariable Integer id) {
		
		return PPR.findById(id).get();
		}
	@RequestMapping(value="/personnephysique",method = RequestMethod.POST)
	public PersonnePhysique savepersonnephysique(@RequestBody PersonnePhysiqueDto t) {
		return pps.postPersonnePhysique(t);
	}
	 @PostMapping("/personnephysique/update/{id}")
	    public PersonnePhysique update(@PathVariable("id") int id, @RequestBody PersonnePhysiqueDto userdto)  {
		return pps.update(id,userdto);
	  }

	@RequestMapping(value = "/personnephysique/{id}",method = RequestMethod.PUT)
	public String updatepersonnephysique(@RequestBody PersonnePhysique t , @PathVariable Integer id) {
		t.setId(id);
		PPR.save(t);
		return "personne physique mis a jou";
	}
	@RequestMapping(value = "/personnephysique/{id}",method = RequestMethod.DELETE)
	public String deletepersonnephysiquebyid (@PathVariable Integer id) {
		PPR.deleteById(id);
		return "personne physique "+ id+ " suprimé";
	}
	@RequestMapping(value = "/personnephysique",method = RequestMethod.DELETE)
	public String deleteallpersonnephysiques() {
		PPR.deleteAll();
		return "tous les personnes physiques sont suprimés";
	}


}
