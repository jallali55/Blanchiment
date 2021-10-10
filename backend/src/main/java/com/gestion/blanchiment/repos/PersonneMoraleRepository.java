package com.gestion.blanchiment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.blanchiment.entities.PersonneMorale;
import com.gestion.blanchiment.entities.PersonnePhysique;

public interface PersonneMoraleRepository extends JpaRepository<PersonneMorale, Integer> {
	public PersonneMorale findByNumeroFiscal(String Cin);

}
