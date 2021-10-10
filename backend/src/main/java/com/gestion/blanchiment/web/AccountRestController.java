package com.gestion.blanchiment.web;


import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gestion.blanchiment.dto.Stat;
import com.gestion.blanchiment.dto.Userdto;
import com.gestion.blanchiment.entities.User;
import com.gestion.blanchiment.service.AccountService;

@RequestMapping("/users")
@RestController
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public User signin(@RequestBody Userdto userdto)  {
	return accountService.saveUser(userdto);
    }
    @PostMapping("/update/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody Userdto userdto)  {
	return accountService.update(id,userdto);
    }


    
    @GetMapping(value = "/findByuserName")
    public User findByuserName(@RequestParam("username") String username) {
	return accountService.findUserByUsername(username);
    }
    
    @GetMapping(value = "enable/{id}")
    public ResponseEntity<Object> enable(@PathVariable("id") Long username) {
	return accountService.enable(username);
    }
    @GetMapping(value = "disable/{id}")
    public ResponseEntity<Object> disable(@PathVariable("id") Long username) {
	return accountService.disable(username);
    }
   
  

    @GetMapping
    public ResponseEntity<Object> getAlluser() {
        return accountService.getAll();
    }

    @GetMapping(value = "/getuser/{id_user}")
    public ResponseEntity<Object> getUser(@PathVariable("id_user") Long id_user) {
       return  accountService.getUser(id_user);
    }



    @GetMapping(value = "/Userbyauthority/{authority_id}")
    public ResponseEntity<Object> getUserbyauthority(@PathVariable("authority_id") Long authority_id) {
        return accountService.getUserbyauthority(authority_id);
    }
    

    @GetMapping(value = "/stat")
    public Stat getStat() {
	return accountService.getStat();
    }

  
  

}
