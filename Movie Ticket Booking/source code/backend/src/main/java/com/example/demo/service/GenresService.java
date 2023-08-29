package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.Genres;

public interface GenresService {
	
	public ResponseEntity<String> addGenres(String genre);
	
	public List<Genres> getAllGenres();
	
	public ResponseEntity<String> removeGenres(int id);
	
	public List<Genres> updateGenere(int id, String genre);

}
