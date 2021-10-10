package com.gestion.blanchiment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gestion.blanchiment.dto.PaysDto;
import com.gestion.blanchiment.entities.Pays;

public interface PaysService {
	public Pays postPays(PaysDto paysDto);
	public Pays getPaysById(Integer id);
	public List<Pays> getAllPayss();
	public void deletePaysById(Integer id);
	public void deleteAllPayss();
    public ResponseEntity<Object> douteux(int id);
    public ResponseEntity<Object> nondouteux(int id);

}
