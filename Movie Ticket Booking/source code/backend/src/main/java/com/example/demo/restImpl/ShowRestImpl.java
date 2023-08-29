package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Shows;
import com.example.demo.rest.ShowRest;
import com.example.demo.service.ShowService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ShowRestImpl implements ShowRest{

	@Autowired
	ShowService showService;
	
	@Override
	public ResponseEntity<String> addShow(Shows show) {
		
		return showService.addShow(show);
	}

	@Override
	public List<Shows> getShows() {
		
		return showService.getShows();
	}

	@Override
	public ResponseEntity<String> updateShow(Shows show) {
		
		return showService.updateShow(show);
	}

	@Override
	public ResponseEntity<String> removeShow(int id) {
		
		return showService.removeShow(id);
	}

	@Override
	public List<Shows> getShowsByMovieAndDate(String movie, String movieDate) {
		
		return showService.getShowsByMovieAndDate(movie, movieDate);
	}

}
