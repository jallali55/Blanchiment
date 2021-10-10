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

import com.gestion.blanchiment.entities.Pays;
import com.gestion.blanchiment.repos.PaysRepository;
import com.gestion.blanchiment.service.PaysService;

@RestController
public class PaysRestService {
	
		@Autowired
		private PaysService paysservice;
	
		@Autowired
		PaysRepository PR;
		
		@RequestMapping(value="/pays",method = RequestMethod.GET)
		public List<Pays> getpays(){
			return PR.findAll();
		}
		@RequestMapping(value="/pays/{id}",method = RequestMethod.GET)
		public Pays getpaysbyid(@PathVariable Integer id) {
			
			return PR.findById(id).get();
			}
		
		 @GetMapping(value = "/pays/douteux/{id}")
		    public ResponseEntity<Object> douteux(@PathVariable("id") int id) {
			return paysservice.douteux(id);
		    }
		 @GetMapping(value = "/pays/nondouteux/{id}")
		    public ResponseEntity<Object> nondouteux(@PathVariable("id") int id) {
			return paysservice.nondouteux(id);
		    }
		@RequestMapping(value="/pays",method = RequestMethod.POST)
		public String savepays(@RequestBody Pays t) {
			PR.save(t);
			return "pays sauvegardé";
		}
		@RequestMapping(value = "/pays/{id}",method = RequestMethod.PUT)
		public String updatepays(@RequestBody Pays t , @PathVariable Integer id) {
			t.setId(id);
			PR.save(t);
			return "pays mis a jou";
		}
		@RequestMapping(value = "/pays/{id}",method = RequestMethod.DELETE)
		public String deletepaysbyid (@PathVariable Integer id) {
			PR.deleteById(id);
			return "pays "+ id+ " suprimé";
		}
		@RequestMapping(value = "/pays",method = RequestMethod.DELETE)
		public String deleteallpayss() {
			PR.deleteAll();
			return "tous les payss sont suprimés";
		}

	}

	

