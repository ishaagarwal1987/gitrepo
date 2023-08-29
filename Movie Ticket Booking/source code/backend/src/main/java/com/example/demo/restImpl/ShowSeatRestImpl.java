package com.example.demo.restImpl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ShowSeat;
import com.example.demo.rest.ShowSeatRest;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ShowSeatRestImpl implements ShowSeatRest{

	@Override
	public ResponseEntity<String> addShowSeat(ShowSeat showSeat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShowSeat> getShowSeats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> updateShowSeat(int id, ShowSeat showSeat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> removeShowSeat(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
