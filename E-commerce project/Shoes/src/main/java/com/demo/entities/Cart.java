package com.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
	@OneToOne
	private User user;
	@ManyToOne
	private Footwear footwear;
	private int quantity;
	private int size;
	private double amount;
	
	public Cart() {
		super();
		
	}

	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public Cart(int cart_id, User user, Footwear footwear, int quantity, int size, double amount) {
		super();
		this.cart_id = cart_id;
		this.user = user;
		this.footwear = footwear;
		this.quantity = quantity;
		this.size = size;
		this.amount = amount;
	}



	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user_id) {
		this.user = user_id;
	}

	public Footwear getFootwear() {
		return footwear;
	}

	public void setFootwear(Footwear footwear_id) {
		this.footwear = footwear_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	

}
