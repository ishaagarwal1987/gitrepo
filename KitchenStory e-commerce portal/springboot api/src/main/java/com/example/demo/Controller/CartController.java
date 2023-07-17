package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Cart;
import com.example.demo.Model.User;
import com.example.demo.Repository.CartRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	private CartRepository cartRepository;
	
	@PostMapping
	public  Cart addToCart(@RequestBody Cart cart)
	{
		//System.out.print("Saving to Cart = "+cart.toString());
		return cartRepository.save(cart);
		//if(cart1!=null)
		//	return ResponseEntity.status(HttpStatus.OK).body("Product Added To Cart Successfully!!");
		//else
		//	return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Could not addd product to cart.");
	}
	
	@GetMapping("/{user}")
	public List<Cart> getCartProducts(@PathVariable("user") String user1)
	{
		try {
		//System.out.print("getting from cart ");
			User user  = new ObjectMapper().readValue(user1,User.class);
		return (List<Cart>) cartRepository.findAllByUser(user);
		
		}catch(Exception ex)
		{
			System.out.print("Exception "+ex);
			return null;
		}
		
	}
	
	@DeleteMapping("/{id}")
	public List<Cart> deleteProductFromCart(@PathVariable("id") int id)
	{	
		Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
	
		cartRepository.deleteById(id);
		return (List<Cart>) cartRepository.findAllByUser(cart.getUser());
		
	}
}
