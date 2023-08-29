package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.Booking;
import com.example.demo.Model.ShowSeat;

public interface BookingService {

	public ResponseEntity<String> saveBooking(String bookingObj, String bookedSeat);
	
	public List<Booking> getBookings();
	
	List<Booking> getBookingsByUser(int user);
	
	List<ShowSeat> getSeatByBooking(int booking);
	
	List<ShowSeat> getSeatsByShow(int showid);
}
