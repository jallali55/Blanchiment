package com.gestion.blanchiment.service;

import com.gestion.blanchiment.dto.OperationDto;
import com.gestion.blanchiment.entities.Operation;

public interface OperationService {
	public Operation postOperation(OperationDto operationDto);

}
