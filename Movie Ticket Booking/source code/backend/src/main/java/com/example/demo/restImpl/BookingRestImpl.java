package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Booking;
import com.example.demo.Model.ShowSeat;
import com.example.demo.rest.BookingRest;
import com.example.demo.service.BookingService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class BookingRestImpl implements BookingRest{

	@Autowired
	BookingService bookingService;
	
	@Override
	public List<Booking> getBookings() {
		
		return bookingService.getBookings();
	}

	@Override
	public ResponseEntity<String> saveBooking(String bookingObj, String bookedSeat) {
		
		return bookingService.saveBooking(bookingObj,bookedSeat);
	}

	@Override
	public List<Booking> getBookingsByUser(int user) {
		
		return bookingService.getBookingsByUser(user);
	}

	@Override
	public List<ShowSeat> getSeatByBooking(int booking) {
		
		return bookingService.getSeatByBooking(booking);
	}

	@Override
	public List<ShowSeat> getSeatsByShow(int showid) {
		
		return bookingService.getSeatsByShow(showid);
	}

}
