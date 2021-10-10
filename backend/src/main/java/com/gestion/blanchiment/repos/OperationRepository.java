package com.gestion.blanchiment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.blanchiment.entities.Operation;
import com.gestion.blanchiment.entities.PersonnePhysique;

public interface OperationRepository extends JpaRepository<Operation, Integer> {

}
