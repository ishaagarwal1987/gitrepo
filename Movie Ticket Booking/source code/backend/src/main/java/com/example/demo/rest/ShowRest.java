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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Shows;

@RequestMapping(path="/shows")
public interface ShowRest {

	@PostMapping
	public ResponseEntity<String> addShow(@RequestBody Shows show);
	
	@PostMapping("/shows")
	public List<Shows> getShowsByMovieAndDate(@RequestParam("movie") String movie,@RequestParam("date") String movieDate);
	
	@GetMapping
	public List<Shows> getShows();
		
	@PutMapping
	public ResponseEntity<String> updateShow(@RequestBody Shows show);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeShow(@PathVariable(value = "id") int id);
	
}
