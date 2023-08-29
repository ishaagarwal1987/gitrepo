package com.example.demo.Model;

import java.sql.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@DynamicUpdate
@Getter @Setter
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingID;
	private int numberOfSeats;
	private Date timeStamp;
	private double amount;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Shows show;
	
	
}
