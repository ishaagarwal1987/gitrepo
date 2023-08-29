package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.Shows;

public interface ShowService {

	public ResponseEntity<String> addShow(Shows show);
	
	public List<Shows> getShowsByMovieAndDate(String movie, String movieDate);
	
	public List<Shows> getShows();
	
	public ResponseEntity<String> updateShow(Shows show);
	
	public ResponseEntity<String> removeShow(int id);
	
}
