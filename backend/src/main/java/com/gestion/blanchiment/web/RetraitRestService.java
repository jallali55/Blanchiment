package com.gestion.blanchiment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.blanchiment.entities.Retrait;
import com.gestion.blanchiment.metier.ActionOperation;
import com.gestion.blanchiment.repos.RetraitRepository;

@RestController
public class RetraitRestService {
	
	@Autowired
	RetraitRepository RR;
	@Autowired
	ActionOperation AO;
	@RequestMapping(value = "/retrait",method = RequestMethod.GET)
	public List<Retrait> getretraits(){
		return RR.findAll();
		}
	
	@RequestMapping(value="/retrait",method = RequestMethod.POST)
	public String retirer(@PathVariable String numcpt,
	Double montant) {
		
		AO.retirer(numcpt, montant);
		return "transaction faite" ;
	}
	@RequestMapping(value="/retrait/{id}",method = RequestMethod.GET)
	public Retrait getretraitbyid(@PathVariable Integer id) {
		
		return RR.findById(id).get();
		}
	
	@RequestMapping(value = "/retrait/{id}",method = RequestMethod.PUT)
	public String updateretrait(@RequestBody Retrait t , @PathVariable Integer id) {
		t.setId(id);
		RR.save(t);
		return "retrait mis a jou";
	}
	@RequestMapping(value = "/retrait/{id}",method = RequestMethod.DELETE)
	public String deleteretraitbyid (@PathVariable Integer id) {
		RR.deleteById(id);
		return "retrait "+ id+ " suprimé";
	}
	@RequestMapping(value = "/retrait",method = RequestMethod.DELETE)
	public String deleteallretraits() {
		RR.deleteAll();
		return "tous les retraits sont suprimés";
	}



}
