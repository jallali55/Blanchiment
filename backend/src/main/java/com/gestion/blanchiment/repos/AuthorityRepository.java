package com.gestion.blanchiment.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.blanchiment.entities.Authority;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
public Authority findByRole(String role);

}
