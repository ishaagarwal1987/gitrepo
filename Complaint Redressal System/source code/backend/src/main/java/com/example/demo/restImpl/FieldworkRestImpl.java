package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Fieldwork;
import com.example.demo.rest.FieldWorkRest;
import com.example.demo.service.FieldworkService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class FieldworkRestImpl implements FieldWorkRest{

	@Autowired
	FieldworkService fieldService;
	
	@Override
	public ResponseEntity<String> addFieldwork(Fieldwork fieldwork) {
		
		return fieldService.addFieldwork(fieldwork);
	}

	@Override
	public List<Fieldwork> geAllFieldworks() {
		
		return fieldService.geAllFieldworks();
	}

}
