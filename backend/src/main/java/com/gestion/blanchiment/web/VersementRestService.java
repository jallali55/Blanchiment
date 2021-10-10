package com.gestion.blanchiment.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.blanchiment.entities.Versement;
import com.gestion.blanchiment.repos.VersementRepository;

@RestController
public class VersementRestService {
	@Autowired
	VersementRepository VR;
	
	@RequestMapping(value="/versement",method = RequestMethod.POST)
	public String saveversement(@RequestBody Versement o) {
		VR.save(o);
		return "versement sauvegardé";}
	@RequestMapping(value="/versement/{id}",method = RequestMethod.GET)
	public Versement getversementbyid(@PathVariable Integer id) {
		
		return VR.findById(id).get();
		}
	
	
	

}
