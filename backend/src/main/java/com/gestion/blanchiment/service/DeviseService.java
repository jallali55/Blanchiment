package com.gestion.blanchiment.service;

import java.util.List;

import com.gestion.blanchiment.dto.DeviseDto;
import com.gestion.blanchiment.entities.Devise;

public interface DeviseService {
	public Devise postDevise(DeviseDto deviseDto);
	public Devise getDeviseById(Integer id);
	public List<Devise> getAllDevises();
	public void deleteDeviseById(Integer id);
	public void deleteAllDevises();
}
