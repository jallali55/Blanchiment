package com.gestion.blanchiment.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gestion.blanchiment.entities.User;
import com.gestion.blanchiment.service.AccountService;


@Service
public class UserDetalilsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user=accountService.findUserByUsername(username);
	if(user==null)
	    {throw new UsernameNotFoundException("User "+username+" Not Found");
	    }
	if(user.getEnabled().equals(false)) {
	    throw new RuntimeException("User "+username+" is disabled");
	}
	if(user.getIsdeleted().equals(true)) {
	    throw new RuntimeException("User "+username+" is deleted");
	}
Collection<GrantedAuthority> authorities=new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(user.getAuthority().getRole()));

    return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

}
