package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Cart;

import com.example.demo.rest.CartRest;
import com.example.demo.service.CartService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CartRestImpl implements CartRest{

	@Autowired
	CartService cartService;
	
	@Override
	public ResponseEntity<String> addToCart(Cart cart) {
		
		return cartService.addToCart(cart);
	}

	
	@Override
	public ResponseEntity<String> removeCart(int id) {
		
		return cartService.removeCart(id);
	}

	

	@Override
	public List<Cart> getCartByUser(String user) {
		
		return cartService.getCartByUser(user);
	}


	@Override
	public ResponseEntity<String> updateCart(int id, Cart cart) {
		
		return cartService.updateCart(cart);
	}

}
