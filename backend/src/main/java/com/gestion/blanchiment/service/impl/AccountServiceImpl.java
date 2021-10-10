package com.gestion.blanchiment.service.impl;



import java.security.SecureRandom;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.blanchiment.dto.Stat;
import com.gestion.blanchiment.dto.Userdto;
import com.gestion.blanchiment.entities.Authority;
import com.gestion.blanchiment.entities.User;
import com.gestion.blanchiment.enums.StatutCompte;
import com.gestion.blanchiment.repos.AuthorityRepository;
import com.gestion.blanchiment.repos.ClientSuspectRepository;
import com.gestion.blanchiment.repos.CompteRepository;
import com.gestion.blanchiment.repos.PersonneMoraleRepository;
import com.gestion.blanchiment.repos.PersonnePhysiqueRepository;
import com.gestion.blanchiment.repos.TierRepository;
import com.gestion.blanchiment.repos.UserRepository;
import com.gestion.blanchiment.service.AccountService;
import com.gestion.blanchiment.service.ResponseService;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
   @Autowired
   private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private TierRepository tierRepository;
    @Autowired
    private PersonneMoraleRepository personneMoraleRepository;
    @Autowired
    private PersonnePhysiqueRepository personnePhysiqueRepository;
    @Autowired
    private ClientSuspectRepository clientSuspectRepository;
    @Override
    public User saveUser(Userdto userdto)  {
	if(this.findUserByUsername(userdto.getUsername())!=null) throw new RuntimeException("This user already exist");
	if(!authorityRepository.findById(userdto.getAuthority()).isPresent()) throw new  RuntimeException("Authority not found");
	User user=modelMapper.map(userdto,User.class);
	user.setAuthority(authorityRepository.findById(userdto.getAuthority()).get());
	user.setIsdeleted(false);
	user.setEnabled(userdto.isIsenabled());
	user.setPassword(bCryptPasswordEncoder.encode
		(userdto.getPassword()));
		User saveduser= userRepository.save(user);
		return userRepository.findById(saveduser.getId()).get();

    }

    @Override
    public Authority saveRole(Authority role) {
	return authorityRepository.save(role); 
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
	Authority authority=authorityRepository.findByRole(roleName);
	User user=userRepository.findByUsername(username);
	user.getAuthority();
	
    }

    @Override
    public User findUserByUsername(String username) {	
	return userRepository.findByUsername(username);
    }

   

     
    
    
 
  
       //get all user
       @Override
       public  ResponseEntity<Object>  getAll() {
           List<User> result = userRepository.findAll().stream().filter(e -> e.getIsdeleted().equals(false)).collect(Collectors.toList());
           if (result.isEmpty())
               return responseService.getBadResponse(-1, "List of users is empty");
           return responseService.getResponse(1, "List of users is not empty", result);
       }


       @Override

       public  ResponseEntity<Object>  getUser(Long iduser) {
           Optional<User> optionalUser = userRepository.findById(iduser);


           if (!optionalUser.isPresent())
               return responseService.getBadResponse(-1, "USER NOT FOUND WITH ID    "+iduser);
           return responseService.getResponse(1, "USER FOUND", optionalUser);
       }

  
       @Override
       public  ResponseEntity<Object>  getUserbyauthority(Long authority_id) {
           Optional<Authority> optional = authorityRepository.findById(authority_id);
           if (optional.isPresent()) {
           List<User> result = userRepository.findAll().stream().filter(e -> e.getAuthority().getId().equals(authority_id)).collect(Collectors.toList());
           if (result.isEmpty())
               return responseService.getBadResponse (-1, "List of users Authority is empty"+"id actiitysector"+authority_id);
           return responseService.getResponse(1, "List of users Authority is not empty", result);
           }
           return responseService.getBadResponse(-2, "Any authority with id     "  + authority_id);


       }

	@Override
	public ResponseEntity<Object> enable(Long userId) {
		User user=userRepository.findById(userId).get();
		user.setEnabled(true);
		User savedUser=userRepository.save(user);
        return responseService.getResponse(1, "User Updated", savedUser);

		
	}

	@Override
	public ResponseEntity<Object> disable(Long userId) {
		User user=userRepository.findById(userId).get();
		user.setEnabled(false);
		User savedUser=userRepository.save(user);
        return responseService.getResponse(1, "User Updated", savedUser);
	}

	@Override
	public User update(Long id, Userdto userdto) {
		User user=userRepository.findById(id).get();
		user.setFirstName(userdto.getFirstName());
		user.setLastName(userdto.getLastName());
		user.setEmail(userdto.getEmail());
		user.setPhoneNumber(userdto.getPhoneNumber());
		user.setAuthority(authorityRepository.findById(userdto.getAuthority()).get());
		User saveduser= userRepository.save(user);
		return userRepository.findById(saveduser.getId()).get();
	}

	@Override
	public Stat getStat() {
		Stat stat=new Stat();
		stat.setNbcompte(compteRepository.findAll().size());
		stat.setNbcompteactif(compteRepository.findByStatut(StatutCompte.actif).size());
		stat.setNbcompteinactif(compteRepository.findByStatut(StatutCompte.inactif).size());
		stat.setNbtier(tierRepository.findAll().size());
		stat.setNbphysique(personnePhysiqueRepository.findAll().size());
		stat.setNbmoral(personneMoraleRepository.findAll().size());
		stat.setNbsuspect(clientSuspectRepository.findAll().size());
		stat.setNbuser(userRepository.findAll().size());
		return stat;

		
	}
           
}
