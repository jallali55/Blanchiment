package com.gestion.blanchiment.service;

import java.io.IOException;
import java.util.List;

import com.gestion.blanchiment.dto.ClientSuspectDto;
import com.gestion.blanchiment.entities.ClientSuspect;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
public interface ClientSuspectService {
	public ClientSuspect postClientSuspect(ClientSuspectDto clientsuspectdto);
	public ClientSuspect getClientSuspectById (Integer id);
	
	public List<ClientSuspect> getAllClientSuspect ();
	public void DeleteClientSuspectById(Integer id);
	public void DeleteAllClientSuspect();
	
	public Resource loadAsResource(String filename);
	public ResponseEntity<Object> addPictureToEntity(MultipartFile file) throws IOException ;

}
