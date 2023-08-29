package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.CinemaSeat;

public interface CinemaSeatService {

	public ResponseEntity<String> addSeat(CinemaSeat seat);
	
	public List<CinemaSeat> getSeats();
	
	public ResponseEntity<String> updateSeat(CinemaSeat seat);
	
	public ResponseEntity<String> removeSeat(int id);
	
}
