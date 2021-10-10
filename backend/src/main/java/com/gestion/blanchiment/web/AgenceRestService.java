package com.gestion.blanchiment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.blanchiment.dto.AgenceDto;
import com.gestion.blanchiment.entities.Agence;
import com.gestion.blanchiment.repos.AgenceRepository;
import com.gestion.blanchiment.service.AgenceService;

@RestController
public class AgenceRestService {
	@Autowired
	AgenceRepository AR;
	@Autowired
	AgenceService as;
	
	@RequestMapping(value = "/agence",method = RequestMethod.GET)
	public List<Agence> getagences(){
		return AR.findAll();
	}
	@RequestMapping(value = "/agence/{id}",method = RequestMethod.GET)
	public Agence getagencebyid(@PathVariable Integer id){
		return AR.findById(id).get();
	}
	@RequestMapping(value = "/agence",method = RequestMethod.POST)
	public Agence saveagence(@RequestBody AgenceDto a) {
		return as.postAgence(a);
	}
	
	@RequestMapping(value = "/agence/{id}",method = RequestMethod.PUT)
	public String updateagence(@RequestBody Agence a,@PathVariable Integer id) {
		a.setId(id);
		AR.save(a);
		return " agence mise a jour";
	}
	
	@RequestMapping(value = "/agence/{id}",method = RequestMethod.DELETE)
	public String deleteagencebyid (@PathVariable Integer id) {
		AR.deleteById(id);
		return "agence "+ id+ " suprimé";
	}
	@RequestMapping(value = "/agence",method = RequestMethod.DELETE)
	public String deleteallagences() {
		AR.deleteAll();
		return "tous les agences sont suprimés";
	}
	
	
}
