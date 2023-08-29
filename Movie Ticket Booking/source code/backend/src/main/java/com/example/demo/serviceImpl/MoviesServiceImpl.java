package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Genres;
import com.example.demo.Model.Movie;
import com.example.demo.repository.GenresRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;

import com.example.demo.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MoviesServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	GenresRepository genresRepository;

	@Override
	public ResponseEntity<String> addMovie(String movieObj, MultipartFile file) {
		try {

			ObjectMapper mapper = new ObjectMapper();

			Movie movie = mapper.readValue(movieObj, Movie.class);
			movie.setImage(file.getOriginalFilename());
			Utils.saveFile(movie.getImage(), file);

			movieRepository.save(movie);

			return Utils.getResponseEntity("Movie added SuccessFully", HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Utils.getResponseEntity("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<Movie> getMovies() {

		return movieRepository.findAll();
	}

	@Override
	public ResponseEntity<String> deleteMovie(int id) {
		try {

			Movie movie = movieRepository.findById(id).orElseThrow(null);

			Utils.deleteFile(movie.getImage());
			movieRepository.deleteById(id);

			return Utils.getResponseEntity("Movie deleted SuccessFully", HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Utils.getResponseEntity("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<String> updateMovie(String movieObj, MultipartFile file) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Movie movie = mapper.readValue(movieObj, Movie.class);
			
			Movie updateMovie = movieRepository.findById(movie.getMovieid()).orElseThrow(null);
			
			if(updateMovie!=null && !updateMovie.getImage().equals(file.getOriginalFilename()))
			{
				Utils.deleteFile(updateMovie.getImage());
				movie.setImage(file.getOriginalFilename());
				Utils.saveFile(movie.getImage(), file);
			}
			movieRepository.save(movie);

			return Utils.getResponseEntity("Movie updated SuccessFully", HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Utils.getResponseEntity("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}

	@Override
	public List<Movie> getFewMovies() {
		try {
			return movieRepository.findFewMovies();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<Movie> getMoviesByGenres(int genreid) {
		try {
			
			Genres genre = genresRepository.findById(genreid).orElseThrow(null);
			
			return movieRepository.findByGenre(genre);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

}
