package com.gestion.blanchiment.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.blanchiment.entities.Compte;
import com.gestion.blanchiment.enums.StatutCompte;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
 public Compte findByNumcpt(long numcpt);

public Compte findByNumcpt(String numcpt);
public List<Compte> findByStatut(StatutCompte actif);
}
