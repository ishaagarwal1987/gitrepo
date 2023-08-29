package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.CinemaSeat;
import com.example.demo.repository.CinemaSeatRepository;
import com.example.demo.service.CinemaSeatService;
import com.example.demo.utils.Utils;

@Service
public class CinemaSeatServiceImpl implements CinemaSeatService{

	@Autowired
	CinemaSeatRepository seatRepository;
	
	@Override
	public ResponseEntity<String> addSeat(CinemaSeat seat) {
		
		try {

			seatRepository.save(seat);
			return Utils.getResponseEntity("Seat Added SuccessFully.", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return Utils.getResponseEntity("Something went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<CinemaSeat> getSeats() {
		
		return seatRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updateSeat(CinemaSeat seat) {

		try {

			seatRepository.save(seat);
			return Utils.getResponseEntity("Seat Updated SuccessFully.", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return Utils.getResponseEntity("Something went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> removeSeat(int id) {
		try {

			seatRepository.deleteById(id);
			return Utils.getResponseEntity("Seat deleted SuccessFully.", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return Utils.getResponseEntity("Something went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
