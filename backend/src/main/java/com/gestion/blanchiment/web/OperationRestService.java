package com.gestion.blanchiment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.blanchiment.dto.OperationDto;
import com.gestion.blanchiment.entities.Operation;
import com.gestion.blanchiment.repos.OperationRepository;
import com.gestion.blanchiment.service.OperationService;

@RestController
public class OperationRestService {
	@Autowired
	OperationRepository OR;
	@Autowired
	private OperationService operationService;
	@RequestMapping(value = "/operation",method = RequestMethod.GET)
	public List<Operation> getoperations(){
		return OR.findAll();
		}
	@RequestMapping(value="/operation",method = RequestMethod.POST)
	public Operation saveoperation(@RequestBody OperationDto o) {
		return operationService.postOperation(o);
		}
	@RequestMapping(value="/operation/{id}",method = RequestMethod.GET)
	public Operation getoperationbyid(@PathVariable Integer id) {
		
		return OR.findById(id).get();
		}
	
	@RequestMapping(value = "/operation/{id}",method = RequestMethod.PUT)
	public String updateoperation(@RequestBody Operation t , @PathVariable Integer id) {
		t.setId(id);
		OR.save(t);
		return "operation mis a jou";
	}
	@RequestMapping(value = "/operation/{id}",method = RequestMethod.DELETE)
	public String deleteoperationbyid (@PathVariable Integer id) {
		OR.deleteById(id);
		return "operation "+ id+ " suprimé";
	}
	@RequestMapping(value = "/operation",method = RequestMethod.DELETE)
	public String deletealloperations() {
		OR.deleteAll();
		return "tous les operations sont suprimés";
	}


}
