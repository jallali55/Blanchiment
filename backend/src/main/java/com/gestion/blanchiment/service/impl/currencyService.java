package com.gestion.blanchiment.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestion.blanchiment.dto.ResponseCurrency;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class currencyService {
	public ResponseCurrency currency_converter(String from, String to, float quantite) throws JsonMappingException, JsonProcessingException {
		String fromTo=from+"_"+to;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response
		  = restTemplate.getForEntity("https://free.currconv.com/api/v7/convert?q="+fromTo+"&compact=ultra&apiKey=d5af239b5a0ebfc32bc4", String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		String json=root.toString();
		ResponseCurrency responseCurrency=new ResponseCurrency(from, to, quantite, Float.valueOf((String) json.subSequence(json.lastIndexOf(":")+1, json.lastIndexOf("}"))));
		return responseCurrency;
	}
	
}
