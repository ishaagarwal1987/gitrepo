package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Fieldwork;

@RequestMapping(path="/fieldworks")
public interface FieldWorkRest {

	@PostMapping
	public ResponseEntity<String> addFieldwork(@RequestBody Fieldwork fieldwork);
	
	@GetMapping
	public List<Fieldwork> geAllFieldworks();
	
}
