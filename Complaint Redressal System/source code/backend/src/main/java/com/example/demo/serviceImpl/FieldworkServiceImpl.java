package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Fieldwork;
import com.example.demo.Utils.Utils;
import com.example.demo.repository.FieldworkRepository;
import com.example.demo.service.FieldworkService;

@Service
public class FieldworkServiceImpl implements FieldworkService{
	
	@Autowired
	FieldworkRepository fieldworkRepository;

	@Override
	public ResponseEntity<String> addFieldwork(Fieldwork fieldwork) {
		try {
			fieldworkRepository.save(fieldwork);
			return Utils.getResponseEntity("Fieldworker assigned successfully.", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Utils.getResponseEntity("Someting Went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public List<Fieldwork> geAllFieldworks() {
		
		return fieldworkRepository.findAll();
	}

}
