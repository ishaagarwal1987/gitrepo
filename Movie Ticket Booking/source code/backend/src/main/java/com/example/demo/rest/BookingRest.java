package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Booking;
import com.example.demo.Model.ShowSeat;

@RequestMapping(path="/booking")
public interface BookingRest {

	@PostMapping
	public ResponseEntity<String> saveBooking(@RequestParam("booking") String bookingObj,@RequestParam("bookedSeats") String bookedSeat);
	
	@GetMapping
	public List<Booking> getBookings();
	
	@GetMapping("/user/{user}")
	public List<Booking> getBookingsByUser(@PathVariable(value = "user") int user);
	
	@GetMapping("/seat/{booking}")
	public List<ShowSeat> getSeatByBooking(@PathVariable(value = "booking") int booking);
	
	@GetMapping("/show/{showid}")
	public List<ShowSeat> getSeatsByShow(@PathVariable(value = "showid") int showid);
	
}
