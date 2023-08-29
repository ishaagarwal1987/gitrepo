package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Movie;



@RequestMapping(path="/movies")
public interface MoviesRest {
	
	@PostMapping
	public ResponseEntity<String> addMovie(@RequestParam("addMovie") String movieObj,@RequestParam(value = "image") MultipartFile file);

	@GetMapping
	public List<Movie> getMovies();
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable(value = "id") int id);
	
	@PostMapping("/update")
	public ResponseEntity<String> updateMovie(@RequestParam("updateMovie") String movieObj,@RequestParam(value = "image") MultipartFile file);
	
		
	@GetMapping("/few")
	public List<Movie> getFewMovies();
	
	@GetMapping("/genres/{genre}")
	public List<Movie> getMoviesByGenres(@PathVariable(value = "genre") int genreid);
	
}
