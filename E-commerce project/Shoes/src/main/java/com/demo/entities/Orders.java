package com.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	@ManyToOne
	private User user;
	private String shippingAddress;
	private double totalAmount;
	private String createdOn; 
	private String status;
	private double discount;
	private double deliveryCharges;
	private double subTotal;
	
	
	public Orders() {
		
	}

	public Orders(int order_id, User user, String shippingAddress, double totalAmount, String createdOn,
			String status, double discount, double deliveryCharges,double subTotal) {
		super();
		this.order_id = order_id;
		this.user = user;
		this.shippingAddress = shippingAddress;
		this.totalAmount = totalAmount;
		this.createdOn = createdOn;
		this.status = status;
		this.discount = discount;
		this.deliveryCharges = deliveryCharges;
		this.subTotal = subTotal;
	}



	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	} 
	
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	
}
