package com.example.demo.Model;

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
	private Product product;
	private int quantity;
	private double amount;
	
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(int orderDetails_id, Orders order, Product product, int quantity, double amount) {
		super();
		this.orderDetails_id = orderDetails_id;
		this.order = order;
		this.product = product;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
