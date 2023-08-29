package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.Cart;


public interface CartService {
	
	public ResponseEntity<String> addToCart(Cart cart);
	
	public List<Cart> getCartByUser(String user);
	
	public ResponseEntity<String> removeCart(int id);
	
	public ResponseEntity<String> updateCart(Cart cart);

}
