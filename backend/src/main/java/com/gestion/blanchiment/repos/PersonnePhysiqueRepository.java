package com.gestion.blanchiment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.blanchiment.entities.PersonnePhysique;

public interface PersonnePhysiqueRepository extends JpaRepository<PersonnePhysique, Integer> {

	public PersonnePhysique findByCIN(String Cin);
}
