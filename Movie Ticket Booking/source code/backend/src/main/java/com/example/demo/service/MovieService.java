package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Movie;

public interface MovieService {

	public ResponseEntity<String> addMovie(String movieObj, MultipartFile file);
	
	public List<Movie> getMovies();
	
	public ResponseEntity<String> deleteMovie(int id);
	
	public ResponseEntity<String> updateMovie(String movieObj, MultipartFile file);
	
	public List<Movie> getFewMovies();
	
	public List<Movie> getMoviesByGenres(int genre);
}
