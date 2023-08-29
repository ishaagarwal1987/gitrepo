package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Orders;
import com.example.demo.Model.OrderDetail;

@RequestMapping(path="/orders")
public interface OrderRest {
	
	@PostMapping
	public Orders saveOrder(@RequestBody Orders order);
	
	@GetMapping("/{user}")
	public List<Orders> getOrderByUser(@PathVariable("user") String user);
	
	@GetMapping
	public List<Orders> getOrders();
	
	@GetMapping("/details/{id}")
	public List<OrderDetail> getOrderDetails(@PathVariable("id") int id);

}
