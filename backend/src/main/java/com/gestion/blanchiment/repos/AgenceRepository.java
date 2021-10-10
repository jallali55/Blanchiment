package com.gestion.blanchiment.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.blanchiment.entities.Agence;



public interface AgenceRepository extends JpaRepository<Agence, Integer> {
	public List<Agence>  findByAdresse(String adresse);
	public List<Agence> findByLibcou(String libcou);
	
	
	public List<Agence> findByLiblon(String liblon);
}
