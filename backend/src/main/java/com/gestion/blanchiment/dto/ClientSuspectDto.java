package com.gestion.blanchiment.dto;



public class ClientSuspectDto {
	private Integer id;
	private String niveau_risque;	
	private Integer id_operation;
	
	
	public String getNiveau_risque() {
		return niveau_risque;
	}
	public void setNiveau_risque(String niveau_risque) {
		this.niveau_risque = niveau_risque;
	}
	
	public Integer getId_operation() {
		return id_operation;
	}
	public void setId_operation(Integer id_operation) {
		this.id_operation = id_operation;
	}
	public ClientSuspectDto(String niveau_risque, Integer id_operation) {
		super();
		this.niveau_risque = niveau_risque;
		
		this.id_operation = id_operation;
	}
	public ClientSuspectDto() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
