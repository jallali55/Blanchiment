package com.gestion.blanchiment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gestion.blanchiment.dto.ResponseCurrency;
import com.gestion.blanchiment.entities.Devise;
import com.gestion.blanchiment.repos.DeviseRepository;
import com.gestion.blanchiment.service.impl.currencyService;

@RestController
public class DeviseRestService {
	@Autowired
	DeviseRepository DR;
	@Autowired
	private currencyService currencyservice;
	@GetMapping(value="/devise/currency-converter/from/{from}/to/{to}/quantite/{quantite}")
	public ResponseCurrency currencyConverter(@PathVariable("from") String from,@PathVariable("to") String to,
			@PathVariable("quantite") float quantite) throws JsonMappingException, JsonProcessingException {
		return currencyservice.currency_converter(from, to, quantite);
	}
	@RequestMapping(value = "/devise",method = RequestMethod.GET)
	public List<Devise> getdevises(){
		
		return DR.findAll();
	}
	@RequestMapping(value = "/devise/{id}",method = RequestMethod.GET)
	public Devise getdevisebyid(@PathVariable Integer id) {
		return DR.findById(id).get();
		
	}
	@RequestMapping(value = "/devise",method = RequestMethod.POST)
	public String savedevise(@RequestBody Devise d) {
		DR.save(d);
		return "devise enregistrée";
	}
	@RequestMapping(value = "/devise/{id}",method = RequestMethod.PUT)
	public String updatedevise(@PathVariable Integer id,@RequestBody Devise d ) {
		d.setId(id);
		DR.save(d);
		return "devise mise a jour";
	}
	@RequestMapping(value = "/devise",method = RequestMethod.DELETE)
	public String deletedevises() {
		DR.deleteAll();
		return "tous les devises sont suprimées";
	}
	@RequestMapping(value = "/devise/{id}",method = RequestMethod.DELETE)
	public String deletedevisebyid(@PathVariable Integer id) {
		DR.deleteById(id);
		return"devise "+ id +" suprimée";
		
	}
	
	
	
	
	
}
