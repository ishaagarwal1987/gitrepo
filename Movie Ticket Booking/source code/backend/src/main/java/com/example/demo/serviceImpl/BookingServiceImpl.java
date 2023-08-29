package com.example.demo.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Booking;
import com.example.demo.Model.CinemaSeat;
import com.example.demo.Model.ShowSeat;
import com.example.demo.Model.Shows;
import com.example.demo.Model.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.ShowRepository;
import com.example.demo.repository.ShowSeatRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingService;
import com.example.demo.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	ShowSeatRepository seatRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ShowRepository showRepository;

	@Override
	public ResponseEntity<String> saveBooking(String bookingObj, String bookedSeat) {
		try {
			ObjectMapper mapper = new ObjectMapper();

			Booking booking = mapper.readValue(bookingObj, Booking.class);

			Booking obj = bookingRepository.save(booking);

			List<CinemaSeat> seatsbooked = Arrays.asList(mapper.readValue(bookedSeat, CinemaSeat[].class));
			System.out.println("Booked Seats: " + seatsbooked);
			for (CinemaSeat seat : seatsbooked) {
				ShowSeat s = new ShowSeat();
				s.setBooking(obj);
				s.setCinemaSeat(seat);
				seatRepository.save(s);
			}

			return Utils.getResponseEntity("Tickets Booked SuccessFully.", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Booking> getBookings() {

		return bookingRepository.findAll();
	}

	@Override
	public List<Booking> getBookingsByUser(int user) {
		try {

			User user1 = userRepository.findById(user).orElseThrow(null);
			return bookingRepository.findByUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<ShowSeat> getSeatByBooking(int booking) {
		try {
				Booking booking1 = bookingRepository.findById(booking).orElseThrow(null);
			
			return seatRepository.findByBooking(booking1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<ShowSeat> getSeatsByShow(int showid) {
		try {
			
			Shows show = showRepository.findById(showid).orElseThrow(null);
			
			List<Booking> booking = bookingRepository.findByShow(show);
			
			return seatRepository.findAllByBookingIn(booking);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
