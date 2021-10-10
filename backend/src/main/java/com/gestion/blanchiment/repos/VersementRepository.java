package com.gestion.blanchiment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.blanchiment.entities.Versement;

public interface VersementRepository extends JpaRepository<Versement, Integer> {

}
