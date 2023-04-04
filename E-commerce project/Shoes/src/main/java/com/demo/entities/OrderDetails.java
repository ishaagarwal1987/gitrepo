package com.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetails_id;
	@ManyToOne
	private Orders order;
	@ManyToOne
	private Footwear footwear;
	private int size;
	private int quantity;
	private double amount;
	
	public OrderDetails() {
		
	}

	public OrderDetails(int orderDetails_id, Orders order_id, Footwear footwear_id, int size, int quantity,
			double amount) {
		super();
		this.orderDetails_id = orderDetails_id;
		this.order = order_id;
		this.footwear = footwear_id;
		this.size = size;
		this.quantity = quantity;
		this.amount = amount;
	}

	public int getOrderDetails_id() {
		return orderDetails_id;
	}

	public void setOrderDetails_id(int orderDetails_id) {
		this.orderDetails_id = orderDetails_id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Footwear getFootwear() {
		return footwear;
	}

	public void setFootwear(Footwear footwear) {
		this.footwear = footwear;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
