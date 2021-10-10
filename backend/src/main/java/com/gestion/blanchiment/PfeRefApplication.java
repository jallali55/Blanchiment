package com.gestion.blanchiment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestion.blanchiment.dto.Userdto;
//import com.gestion.blanchiment.entities.Agence;
//import com.gestion.blanchiment.entities.Compte;
//import com.gestion.blanchiment.entities.Devise;
//import com.gestion.blanchiment.entities.Tier;
import com.gestion.blanchiment.repos.AgenceRepository;
import com.gestion.blanchiment.repos.CompteRepository;
import com.gestion.blanchiment.repos.DeviseRepository;
import com.gestion.blanchiment.repos.TierRepository;
import com.gestion.blanchiment.service.impl.AccountServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.modelmapper.ModelMapper;
@SpringBootApplication
public class PfeRefApplication implements CommandLineRunner {

	@Autowired
	TierRepository TR;
	@Autowired
	CompteRepository CR;
	@Autowired
	DeviseRepository DR;
	@Autowired
	AgenceRepository AR;
	@Autowired
	AccountServiceImpl service;
	public static void main(String[] args) {
		SpringApplication.run(PfeRefApplication.class, args);
	}
	 @Bean
	    BCryptPasswordEncoder getBCPE(){
	        return new BCryptPasswordEncoder();
	    }
	 
	 @Bean
		public ModelMapper modelMapper() {
		    return new ModelMapper();
		}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
