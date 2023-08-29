package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Genres;
import com.example.demo.repository.GenresRepository;
import com.example.demo.service.GenresService;
import com.example.demo.utils.Utils;

@Service
public class GenesServiceImpl implements GenresService{

	@Autowired
	GenresRepository genresRepository;

	@Override
	public ResponseEntity<String> addGenres(String genre) {
		try {

			Genres genres = new Genres();
			genres.setGenrename(genre);
			genresRepository.save(genres);

			return Utils.getResponseEntity("Genre SuccessFully Added.", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Utils.getResponseEntity("Something went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public List<Genres> getAllGenres() {

		return genresRepository.findAll();
	}

	@Override
	public ResponseEntity<String> removeGenres(int id) {

		try {
			genresRepository.deleteById(id);

			return Utils.getResponseEntity("Genre Deleted SuccessFully", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Utils.getResponseEntity("Something went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public List<Genres> updateGenere(int id, String genre) {
		try {

			Genres genres = new Genres();
			genres.setGenreid(id);
			genres.setGenrename(genre);
			genresRepository.save(genres);

			return getAllGenres();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
