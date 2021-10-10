package com.gestion.blanchiment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.blanchiment.entities.Retrait;

public interface RetraitRepository extends JpaRepository<Retrait, Integer>{

}
