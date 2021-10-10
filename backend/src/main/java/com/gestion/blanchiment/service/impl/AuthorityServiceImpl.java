package com.gestion.blanchiment.service.impl;


import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestion.blanchiment.dto.AuthorityDto;
import com.gestion.blanchiment.entities.Authority;
import com.gestion.blanchiment.repos.AuthorityRepository;
import com.gestion.blanchiment.repos.UserRepository;
import com.gestion.blanchiment.service.AuthorityService;
import com.gestion.blanchiment.service.ResponseService;

import java.util.List;
import java.util.Optional;

@Service

public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private AuthorityRepository authorityrepository;
    @Autowired
    private UserRepository userrepository;
    @Autowired
    private ModelMapper mapper;

    // Add and update
    public ResponseEntity<Object> addAuthority(AuthorityDto authorityDto) {
        Authority authority = mapper.map(authorityDto, Authority.class);



      Authority authority1 = authorityrepository.save(authority);
        return responseService.getResponse(0, "Auhtority Successfully added", authority1);
    }

    @Override
    public ResponseEntity<Object> updateAuthority(Long Id, AuthorityDto authorityDto) {
        Optional<Authority> optional = authorityrepository.findById(Id);
        if (!optional.isPresent()) {
            return responseService.getBadResponse(-1,
                    "No AUTHORITY found with id = " + Id);
        }
      Authority authority = optional.get();
        authority = modelMapper.map(authorityDto,Authority.class);
        authority.setId(Id);

        authority.setRole(optional.get().getRole());

     Authority savedEntity = authorityrepository.save(authority);
        return responseService.getResponse(1, "authority successfully updated",
                savedEntity);
    }
    //get all
    @Override
    public ResponseEntity<Object> deleteAuthority(Long id) {
        Optional<Authority> optionalAuthority = authorityrepository.findById(id);
        if (optionalAuthority.isPresent()) {
            authorityrepository.delete(optionalAuthority.get());
            return responseService.getResponse(1, "Authority Successfully deleted", null);
        }
        return responseService.getBadResponse(-1, "Authority Not found" + "with" + id);
    }

    @Override
    public ResponseEntity<Object> getAllAuthority() {
        List<Authority> result = authorityrepository.findAll();
        if (!result.isEmpty()) {
            return responseService.getResponse(-1, "List of authority is not empty", result);
        }
    return responseService.getBadResponse(0,"List of authority is empty");
}
    @Override

    public ResponseEntity<Object> getAuthority(Long id) {
        Optional<Authority> optionalAuthority = authorityrepository.findById(id);


        if (!optionalAuthority.isPresent())
            return responseService.getBadResponse(-1, " authority NOT FOUND with id "+id);
        return responseService.getResponse(1, "Authority FOUND", optionalAuthority);
    }

   


}


