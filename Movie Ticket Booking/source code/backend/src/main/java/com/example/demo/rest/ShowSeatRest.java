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

import com.example.demo.Model.ShowSeat;

@RequestMapping(path="/showseat")
public interface ShowSeatRest {

	@PostMapping
	public ResponseEntity<String> addShowSeat(@RequestBody ShowSeat showSeat);
	
	@GetMapping
	public List<ShowSeat> getShowSeats();
		
	@PutMapping("/{id}")
	public ResponseEntity<String> updateShowSeat(@PathVariable(value = "id") int id,@RequestBody ShowSeat showSeat);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeShowSeat(@PathVariable(value = "id") int id);
}
