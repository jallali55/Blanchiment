package com.gestion.blanchiment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.blanchiment.entities.Pays;

public interface PaysRepository extends JpaRepository<Pays, Integer> {

}
