package com.gestion.blanchiment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.blanchiment.entities.Devise;

public interface DeviseRepository extends JpaRepository<Devise, Integer> {

}
