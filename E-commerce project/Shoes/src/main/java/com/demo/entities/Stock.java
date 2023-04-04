package com.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stock_id;
	@ManyToOne
	private Footwear footwear;
	private int size;
	private int quantity;
	
	public Stock() {
		
	}

	public Stock(int stock_id, Footwear footwear_id, int size, int quantity) {
		super();
		this.stock_id = stock_id;
		this.footwear = footwear_id;
		this.size = size;
		this.quantity = quantity;
	}

	public int getStock_id() {
		return stock_id;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public Footwear getFootwear() {
		return footwear;
	}

	public void setFootwear(Footwear footwear_id) {
		this.footwear = footwear_id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
