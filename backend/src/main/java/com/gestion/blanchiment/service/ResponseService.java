package com.gestion.blanchiment.service;



import org.springframework.http.ResponseEntity;

public interface ResponseService {
    public ResponseEntity<Object> getResponse(int errorcode,String errorDescription,Object responseInfo);
    public ResponseEntity<Object> getBadResponse(int errorcode,String errorDescription);
}
