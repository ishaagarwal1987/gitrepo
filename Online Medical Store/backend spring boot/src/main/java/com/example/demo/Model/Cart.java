package com.example.demo.Model;

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
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartid;
	@ManyToOne
	private User user;
	@ManyToOne
	private Product product;
	private int quantity;
	private double amount;

}
