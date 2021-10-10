package com.gestion.blanchiment.service.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestion.blanchiment.service.ResponseService;


@Service
public class ResponseServiceImpl implements ResponseService {

    @Override
    public ResponseEntity<Object> getResponse(int errorcode, String errorDescription, Object responseInfo) {
	  HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("code",""+errorcode);
	    responseHeaders.set("description", errorDescription);
	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body(responseInfo);
    }
    @Override
    public ResponseEntity<Object> getBadResponse(int errorcode, String errorDescription) {
	  HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("error_code",""+errorcode);
	    responseHeaders.set("error_description", errorDescription);
	    return ResponseEntity.badRequest()
	      .headers(responseHeaders)
	      .body("Service Error");
    }

}
