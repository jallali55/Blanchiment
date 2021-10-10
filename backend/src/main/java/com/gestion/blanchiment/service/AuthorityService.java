package com.gestion.blanchiment.service;



import org.springframework.http.ResponseEntity;

import com.gestion.blanchiment.dto.AuthorityDto;


public interface AuthorityService {
    public  ResponseEntity<Object>  addAuthority(AuthorityDto authorityDto);

    public  ResponseEntity<Object> deleteAuthority(Long id);

    public  ResponseEntity<Object>  getAllAuthority();

    public ResponseEntity<Object> getAuthority(Long id);
    public ResponseEntity<Object> updateAuthority(Long Id,AuthorityDto authorityDto);
}
