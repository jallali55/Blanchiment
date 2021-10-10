package com.gestion.blanchiment.web;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.gestion.blanchiment.dto.AuthorityDto;
import com.gestion.blanchiment.service.AuthorityService;


//@CrossOrigin("*")
@RequestMapping("/authoritys")

@Controller
public class AuthorityController {


    @Autowired
    private AuthorityService authorityService;


    @PostMapping(value = "/addauthority")
    public ResponseEntity<Object> addAuthority(@RequestBody AuthorityDto authorityDto) {
        return authorityService.addAuthority(authorityDto);
    }

    @PutMapping(value="/{authority_id}")
    public ResponseEntity<Object> updateAuthority(@PathVariable("authority_id") Long authority_id,@RequestBody AuthorityDto authorityDto){
        return authorityService.updateAuthority(authority_id,authorityDto) ;
    }
    @DeleteMapping(value = "/deleteauthority/{id}")
    public ResponseEntity<Object> deleteAuthority(@PathVariable("id") Long id) {
        return authorityService.deleteAuthority(id);
    }


    @GetMapping
    public ResponseEntity<Object> getAllAuthority() {
        return  authorityService.getAllAuthority();
    }

    @GetMapping(value = "/{authority_id}")
    public ResponseEntity<Object> getAuthority(@PathVariable("authority_id") Long authority_id) {

return authorityService.getAuthority(authority_id);
    }


}
