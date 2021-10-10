package com.gestion.blanchiment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.blanchiment.dto.PersonneMoraleDto;
import com.gestion.blanchiment.dto.PersonnePhysiqueDto;
import com.gestion.blanchiment.entities.PersonneMorale;
import com.gestion.blanchiment.entities.PersonnePhysique;
import com.gestion.blanchiment.repos.PersonneMoraleRepository;
import com.gestion.blanchiment.service.PersonneMoraleService;

@RestController
public class PersonneMoraleRestService {
	@Autowired
	PersonneMoraleRepository PMR;
	@Autowired
	PersonneMoraleService PMS;
	
	@RequestMapping(value="/personnemorale",method = RequestMethod.GET)
	public List<PersonneMorale> getpersonnemorale(){
		return PMR.findAll();
	}
	@RequestMapping(value="/personnemorale/{id}",method = RequestMethod.GET)
	public PersonneMorale getpersonnemoralebyid(@PathVariable Integer id) {
		
		return PMR.findById(id).get();
		}
	@RequestMapping(value="/personnemorale",method = RequestMethod.POST)
	public PersonneMorale savepersonnemorale(@RequestBody PersonneMoraleDto t) {
		return PMS.postPersonneMorale(t);
	}
	@PostMapping("/personnemorale/update/{id}")
    public PersonneMorale update(@PathVariable("id") int id, @RequestBody PersonneMoraleDto userdto)  {
	return PMS.update(id,userdto);
  }
	@RequestMapping(value = "/personnemorale/{id}",method = RequestMethod.PUT)
	public String updatepersonnemorale(@RequestBody PersonneMorale t , @PathVariable Integer id) {
		t.setId(id);
		PMR.save(t);
		return "personne morale mis a jou";
	}
	@RequestMapping(value = "/personnemorale/{id}",method = RequestMethod.DELETE)
	public String deletepersonnemoralebyid (@PathVariable Integer id) {
		PMR.deleteById(id);
		return "personne morale "+ id+ " suprimé";
	}
	@RequestMapping(value = "/personnemorale",method = RequestMethod.DELETE)
	public String deleteallpersonnemorales() {
		PMR.deleteAll();
		return "tous les personnes morales sont suprimés";
	}


}
