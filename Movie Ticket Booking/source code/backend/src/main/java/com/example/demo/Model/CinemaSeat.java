package com.example.demo.Model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@DynamicUpdate
@Getter @Setter
public class CinemaSeat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cinemaSeatID;
    private String seatNumber;
    private String seatType;
    private double price;
    private boolean active=false;
}
