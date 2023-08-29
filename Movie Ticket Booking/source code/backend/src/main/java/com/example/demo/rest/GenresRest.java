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

import com.example.demo.Model.Genres;

@RequestMapping(path="/genres")
public interface GenresRest {
	
	@PostMapping("/add")
	public ResponseEntity<String> addGenres(@RequestBody String genre);
	
	@GetMapping
	public List<Genres> getAllGenres();
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeGenres(@PathVariable(value = "id") int id);
	
	@PutMapping("/{id}")
	public List<Genres> updateGenere(@PathVariable(value = "id") int id,@RequestBody String genre);

}
