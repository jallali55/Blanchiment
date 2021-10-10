package com.gestion.blanchiment.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.blanchiment.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
public User findByUsername(String username);
}
