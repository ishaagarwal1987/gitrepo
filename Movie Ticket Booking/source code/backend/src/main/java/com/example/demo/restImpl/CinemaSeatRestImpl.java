package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.CinemaSeat;
import com.example.demo.rest.CinemaSeatRest;
import com.example.demo.service.CinemaSeatService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CinemaSeatRestImpl implements CinemaSeatRest{

	@Autowired
	CinemaSeatService seatService;
	
	@Override
	public ResponseEntity<String> addSeat(CinemaSeat seat) {
		
		return seatService.addSeat(seat);
	}

	@Override
	public List<CinemaSeat> getSeats() {
		
		return seatService.getSeats();
	}

	@Override
	public ResponseEntity<String> updateSeat(CinemaSeat seat) {
		
		return seatService.updateSeat(seat);
	}

	@Override
	public ResponseEntity<String> removeSeat(int id) {
		
		return seatService.removeSeat(id);
	}

}
