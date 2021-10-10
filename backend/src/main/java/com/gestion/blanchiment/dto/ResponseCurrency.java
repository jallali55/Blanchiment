package com.gestion.blanchiment.dto;

public class ResponseCurrency {

	private String from;
	private String to;
	private float quantity;
	private float conversionMultiple;
	private float totalCalculatedAmmount;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(float conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public float getTotalCalculatedAmmount() {
		return totalCalculatedAmmount;
	}
	public void setTotalCalculatedAmmount(float totalCalculatedAmmount) {
		this.totalCalculatedAmmount = totalCalculatedAmmount;
	}
	public ResponseCurrency(String from, String to, float quantity, float conversionMultiple) {
		super();
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionMultiple = conversionMultiple;
		this.totalCalculatedAmmount = this.conversionMultiple*this.quantity;
	}
	
	
}
