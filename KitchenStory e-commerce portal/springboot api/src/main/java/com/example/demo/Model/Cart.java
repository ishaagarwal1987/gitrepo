package com.example.demo.Model;

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
	private int cartid;
	@OneToOne
	private User user;
	@ManyToOne
	private Product product;
	private int quantity;
	private double amount;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cart_id, User user, Product product, int quantity, double amount) {
		super();
		this.cartid = cart_id;
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.amount = amount;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", user=" + user + ", product=" + product + ", quantity=" + quantity
				+ ", amount=" + amount + "]";
	}
	
	

}
