package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Booking;
import com.example.demo.Model.Shows;
import com.example.demo.Model.User;


public interface BookingRepository extends JpaRepository<Booking, Integer>{

	List<Booking> findByUser(User user);

	List<Booking> findByShow(Shows show);

}
