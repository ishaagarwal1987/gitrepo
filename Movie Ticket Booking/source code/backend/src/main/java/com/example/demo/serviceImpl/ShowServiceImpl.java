package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Movie;
import com.example.demo.Model.Shows;
import com.example.demo.repository.ShowRepository;
import com.example.demo.service.ShowService;
import com.example.demo.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	ShowRepository showRepository;

	@Override
	public ResponseEntity<String> addShow(Shows show) {
		try {

			showRepository.save(show);
			return Utils.getResponseEntity("Show Added SuccessFully.", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return Utils.getResponseEntity("Something went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public List<Shows> getShows() {

		return showRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updateShow(Shows show) {
		try {

			showRepository.save(show);
			return Utils.getResponseEntity("Show Updated SuccessFully.", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return Utils.getResponseEntity("Something went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> removeShow(int id) {

		try {

			showRepository.deleteById(id);
			return Utils.getResponseEntity("Show deleted SuccessFully.", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return Utils.getResponseEntity("Something went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<Shows> getShowsByMovieAndDate(String movie, String movieDate) {
		try {
			ObjectMapper mapper = new ObjectMapper();

			Movie movieObj = mapper.readValue(movie, Movie.class);
			
			return showRepository.findByMovieAndShowdate(movieObj,movieDate);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
