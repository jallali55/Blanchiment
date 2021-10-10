package com.gestion.blanchiment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.blanchiment.dto.CompteDto;
import com.gestion.blanchiment.entities.Compte;
import com.gestion.blanchiment.repos.CompteRepository;
import com.gestion.blanchiment.service.CompteService;


@RestController
public class CompteRestService {
	@Autowired
	CompteRepository CR;
	@Autowired
	CompteService CS;
	@RequestMapping(value="/compte",method = RequestMethod.GET)
	public List<Compte> getcomptes(){
		return CR.findAll();	
	}
	@RequestMapping(value="/compte/valid",method = RequestMethod.GET)
	public List<Compte> getvalid(){
		return CS.getValid();	
	}
	  @GetMapping(value = "/compte/enable/{id}")
	    public ResponseEntity<Object> enable(@PathVariable("id") int id) {
		return CS.enable(id);
	    }
	    @GetMapping(value = "/compte/disable/{id}")
	    public ResponseEntity<Object> disable(@PathVariable("id") int id) {
		return CS.disable(id);
	    }
	
	@RequestMapping(value = "/compte/{id}",method = RequestMethod.GET)
	public Compte getcomptebyid(@PathVariable Integer id) {
		return CR.findById(id).get();
	}
	@RequestMapping(value = "/compte",method = RequestMethod.POST)
	public Compte savecompte(@RequestBody CompteDto c) {
		return CS.postCompte(c);	
	}
	@RequestMapping(value = "/compte/{id}",method = RequestMethod.PUT)
	public String updateCompte(@RequestBody Compte c,@PathVariable Integer id) {
		c.setId(id);
		CR.save(c);
		return "compte mis a jour";
	}
	@RequestMapping(value = "/compte/{id}",method = RequestMethod.DELETE)
	public String deletecomptebyid(@PathVariable Integer id) {
		CR.deleteById(id);
		return "compte "+ id+" sumprimé";
	}
	@RequestMapping(value = "/compte",method = RequestMethod.DELETE)
	public String deleteallcomptes() {
		
		CR.deleteAll();
		return"tous les comptes sont suprimés";
	}
}
