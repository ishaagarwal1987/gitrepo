package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.Fieldwork;

public interface FieldworkService {
	
	public ResponseEntity<String> addFieldwork(Fieldwork fieldwork);
	
	public List<Fieldwork> geAllFieldworks();

}
