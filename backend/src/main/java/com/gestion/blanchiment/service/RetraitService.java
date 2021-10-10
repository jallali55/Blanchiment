package com.gestion.blanchiment.service;

import java.util.List;

import com.gestion.blanchiment.dto.RetraitDto;
import com.gestion.blanchiment.entities.Operation;

public interface RetraitService {
	public Operation postOperation(RetraitDto Operation);
	public Operation getOperationById(Integer id);
	public List<Operation> getAllOperations();	
	public void deleteOperationById(Integer id);
	public void deleteAllOperations();



}
