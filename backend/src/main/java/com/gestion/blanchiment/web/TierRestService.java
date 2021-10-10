package com.gestion.blanchiment.web;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.blanchiment.entities.Tier;
import com.gestion.blanchiment.repos.TierRepository;

@RestController
public class TierRestService {
	@Autowired
	TierRepository TR;
	
	@RequestMapping(value="/tier",method = RequestMethod.GET)
	public List<Tier> gettier(){
		return TR.findAll();
	}
	@RequestMapping(value="/tier/{id}",method = RequestMethod.GET)
	public Tier gettierbyid(@PathVariable Integer id) {
		
		return TR.findById(id).get();
		}
	@RequestMapping(value="/tier",method = RequestMethod.POST)
	public String savetier(@RequestBody Tier t) {
		TR.save(t);
		return "tier sauvegardé";
	}
	@RequestMapping(value = "/tier/{id}",method = RequestMethod.PUT)
	public String updateTier(@RequestBody Tier t , @PathVariable Integer id) {
		t.setId(id);
		TR.save(t);
		return "tier mis a jou";
	}
	@RequestMapping(value = "/tier/{id}",method = RequestMethod.DELETE)
	public String deletetierbyid (@PathVariable Integer id) {
		TR.deleteById(id);
		return "tier "+ id+ " suprimé";
	}
	@RequestMapping(value = "/tier",method = RequestMethod.DELETE)
	public String deletealltiers() {
		TR.deleteAll();
		return "tous les tiers sont suprimés";
	}
}
