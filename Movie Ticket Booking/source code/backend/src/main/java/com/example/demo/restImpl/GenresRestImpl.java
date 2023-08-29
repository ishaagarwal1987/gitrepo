package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Genres;

import com.example.demo.rest.GenresRest;
import com.example.demo.service.GenresService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class GenresRestImpl implements GenresRest {

	@Autowired
	GenresService genresService;

	@Override
	public ResponseEntity<String> addGenres(String genre) {

		return genresService.addGenres(genre);
	}

	@Override
	public List<Genres> getAllGenres() {

		return genresService.getAllGenres();
	}

	@Override
	public ResponseEntity<String> removeGenres(int id) {

		return genresService.removeGenres(id);
	}

	@Override
	public List<Genres> updateGenere(int id, String genre) {

		return genresService.updateGenere(id, genre);
	}

}
