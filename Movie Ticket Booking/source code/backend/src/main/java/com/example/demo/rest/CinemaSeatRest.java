package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.CinemaSeat;

@RequestMapping(path="/cinemaseats")
public interface CinemaSeatRest {

	@PostMapping
	public ResponseEntity<String> addSeat(@RequestBody CinemaSeat seat);
	
	@GetMapping
	public List<CinemaSeat> getSeats();
	
	
	@PutMapping
	public ResponseEntity<String> updateSeat(@RequestBody CinemaSeat seat);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeSeat(@PathVariable(value = "id") int id);
	
}
