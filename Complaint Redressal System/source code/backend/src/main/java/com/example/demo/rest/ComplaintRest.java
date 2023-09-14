package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Complaint;

@RequestMapping(path="/complaints")
public interface ComplaintRest {
	
	@PostMapping
	public ResponseEntity<String> addComplaint(@RequestBody Complaint complaint);
	
	@GetMapping
	public List<Complaint> geAllComplaints();
	
	@GetMapping("/user/{user}")
	public List<Complaint> getComplaintsByUser(@PathVariable(value = "user") String user);
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateComplaint(@PathVariable(value = "id") int id,@RequestBody String complaint);
	
	@GetMapping("/engineer/{engineer}")
	public List<Complaint> getComplaintsByEngineerAssigned(@PathVariable(value = "engineer") String engineer);

}
