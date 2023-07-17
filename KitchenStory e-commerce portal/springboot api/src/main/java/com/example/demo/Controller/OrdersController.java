package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Cart;
import com.example.demo.Model.OrderDetails;
import com.example.demo.Model.Orders;
import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.OrderDetailsRepository;
import com.example.demo.Repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	OrderDetailsRepository odRepository;
	
	@PostMapping
	public ResponseEntity<String> addOrder(@RequestBody Orders order1)
	{
		try {
			
			Orders order = orderRepository.save(order1);
			OrderDetails orderDetails;
			List<Cart> carts = cartRepository.findAllByUser(order.getUser()); 
			
			for(Cart cart : carts)
			{
				//System.out.println("Cart = " + cart.toString());
				orderDetails = new OrderDetails();
				orderDetails.setOrder(order);
				orderDetails.setProduct(cart.getProduct());
				orderDetails.setQuantity(cart.getQuantity());
				orderDetails.setAmount(cart.getAmount());
				
				odRepository.save(orderDetails);
				//cartRepository.delete(cart);
				
			}
			
			//System.out.println("Carts = " + carts.toString());
			cartRepository.deleteAllByUser(order.getUser());
			
			return ResponseEntity.status(HttpStatus.OK).body("Order Added Successfully!!");
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("");
		}
	}
	
	@GetMapping
	public List<Orders> getAllOrder()
	{
		return (List<Orders>) orderRepository.findAll();
	}
	
	@GetMapping("/{user}")
	public List<Orders> getOrderByUser(@PathVariable("user") String user1)
	{
		try {
		System.out.print("getting from cart ");
			User user  = new ObjectMapper().readValue(user1,User.class);
		return (List<Orders>) orderRepository.findByUser(user);
		
		}catch(Exception ex)
		{
			System.out.print("Exception "+ex);
			return null;
		}
		
	}
	
	//@GetMapping("/{order}")
	//public List<OrderDetails> getOrderDetail(@PathVariable("order") String order1)
	//{
	//	try {
		//System.out.print("getting from cart ");
	//		Orders order  = new ObjectMapper().readValue(order1,Orders.class);
	//	return (List<OrderDetails>) odRepository.findByOrder(order);
		
	//	}catch(Exception ex)
	//	{
	//		System.out.print("Exception "+ex);
	//		return null;
	//	}
		
	//}
	

}
