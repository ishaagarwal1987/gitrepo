package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.Model.Cart;

@RequestMapping(path="/cart")
public interface CartRest {
	
	@PostMapping
	public ResponseEntity<String> addToCart(@RequestBody Cart cart);
	
	@GetMapping("/{user}")
	public List<Cart> getCartByUser(@PathVariable("user") String user);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeCart(@PathVariable(value = "id") int id);
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCart(@PathVariable(value = "id") int id,@RequestBody Cart cart);

}
