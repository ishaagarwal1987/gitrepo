package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Cart;
import com.example.demo.Model.Orders;
import com.example.demo.Model.OrderDetail;
import com.example.demo.Model.User;

import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailRepository odRepo;
	
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public Orders saveOrder(Orders order1) {
		try {
			
			Orders order = orderRepository.save(order1);
			
			OrderDetail orderDetails;
			List<Cart> carts = cartRepository.findByUser(order.getUser()); 

			for(Cart cart : carts)
			{
				//System.out.println("Cart = " + cart.toString());
				orderDetails = new OrderDetail();
				orderDetails.setOrder(order);
				orderDetails.setProduct(cart.getProduct());
				orderDetails.setQuantity(cart.getQuantity());
				orderDetails.setAmount(cart.getAmount());
				
				odRepo.save(orderDetails);
				cartRepository.delete(cart);
				
			}
			
			return order;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<Orders> getOrderByUser(String user1) {
		try {
			
			User user  = new ObjectMapper().readValue(user1,User.class);
			
			return orderRepository.findByUser(user);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<Orders> getOrders() {
		
		return orderRepository.findAll();
	}

	@Override
	public List<OrderDetail> getOrderDetails(int id) {
		try {
			
			Orders order = orderRepository.findById(id).orElseThrow(null);
			
			return odRepo.findByOrder(order);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}

}
