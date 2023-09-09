package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.ChequebookRequest;

@RequestMapping(path="/chequebook")
public interface ChequeBookRequestRest {
	
	@PostMapping
	public ResponseEntity<String> addRequest(@RequestBody ChequebookRequest chequebookRequest);
	
	@GetMapping
	public List<ChequebookRequest> getAllRequests();
	
	@GetMapping("/pending")
	public List<ChequebookRequest> getPendingRequests();
	
	@GetMapping("/pending/{user}")
	public List<ChequebookRequest> getRequestsByUser(@PathVariable(value = "user") String user);
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateStatus(@PathVariable(value = "id") int id,@RequestBody ChequebookRequest chequebookRequest);

}
