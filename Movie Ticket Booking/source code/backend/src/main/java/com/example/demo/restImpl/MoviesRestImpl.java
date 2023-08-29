package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Movie;
import com.example.demo.rest.MoviesRest;
import com.example.demo.service.MovieService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class MoviesRestImpl implements MoviesRest{

	@Autowired
	MovieService movieService;
	
	@Override
	public ResponseEntity<String> addMovie(String movieObj, MultipartFile file) {
		
		return movieService.addMovie(movieObj, file);
	}

	@Override
	public List<Movie> getMovies() {
		
		return movieService.getMovies();
	}

	@Override
	public ResponseEntity<String> deleteMovie(int id) {
		
		return movieService.deleteMovie(id);
	}

	@Override
	public ResponseEntity<String> updateMovie(String movieObj, MultipartFile file) {
		
		return movieService.updateMovie(movieObj, file);
	}

	@Override
	public List<Movie> getFewMovies() {
		
		return movieService.getFewMovies();
	}

	@Override
	public List<Movie> getMoviesByGenres(int genreid) {
		
		return movieService.getMoviesByGenres(genreid);
	}

}
