package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Booking;
import com.example.demo.Model.ShowSeat;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer>{

	List<ShowSeat> findByBooking(Booking booking);

	List<ShowSeat> findAllByBookingIn(List<Booking> booking);

}
