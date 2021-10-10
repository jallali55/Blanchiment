package com.gestion.blanchiment.service;



import org.springframework.http.ResponseEntity;

import com.gestion.blanchiment.dto.Stat;
import com.gestion.blanchiment.dto.Userdto;
import com.gestion.blanchiment.entities.Authority;
import com.gestion.blanchiment.entities.User;


public interface AccountService {
    
    public User saveUser(Userdto userdto);
    public User update(Long id,Userdto userdto);

    public Authority saveRole(Authority role);
    public void addRoleToUser(String username,String roleName); 
    public User findUserByUsername(String username);
    public ResponseEntity<Object> getAll();
    public ResponseEntity<Object> getUser(Long iduser);
    public ResponseEntity<Object> getUserbyauthority(Long authority_id);
    public ResponseEntity<Object> enable(Long userId);
    public ResponseEntity<Object> disable(Long userId);
    
    public Stat getStat();
}
