package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.ShowSeat;

public interface ShowSeatService {

	public ResponseEntity<String> addShowSeat(ShowSeat showSeat);
	
	public List<ShowSeat> getShowSeats();
	
	public ResponseEntity<String> updateShowSeat(int id, ShowSeat showSeat);
	
	public ResponseEntity<String> removeShowSeat(int id);
}
