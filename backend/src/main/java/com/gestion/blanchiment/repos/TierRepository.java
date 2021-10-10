package com.gestion.blanchiment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.blanchiment.entities.Tier;

public interface TierRepository extends JpaRepository<Tier, Integer> {

}
