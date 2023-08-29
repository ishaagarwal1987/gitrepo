package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ShowSeat;
import com.example.demo.service.ShowSeatService;

@Service
public class ShowSeatServiceImpl implements ShowSeatService{

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
