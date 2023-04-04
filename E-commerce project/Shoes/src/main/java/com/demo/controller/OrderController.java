package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entities.Cart;
import com.demo.entities.OrderDetails;
import com.demo.entities.Orders;
import com.demo.entities.User;
import com.demo.repository.CartRepository;
import com.demo.repository.OrderDetailsRepository;
import com.demo.repository.OrdersRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	
	@Autowired
	OrdersRepository orderRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepo;
	
	@PostMapping("/placeOrder")
	public String placeOrder(@ModelAttribute Orders order, Model model, HttpSession session)
	{
		order.setUser((User) session.getAttribute("user"));
		order.setStatus("placed");
		order.setCreatedOn(java.time.LocalDate.now().toString());
		orderRepository.save(order);
		
		User user = (User) session.getAttribute("user");
		Iterable<Cart> cartProducts = cartRepository.findByUser(user);
		
		for(Cart cart:cartProducts)
		{
			OrderDetails od = new OrderDetails();
			od.setOrder(order);
			od.setFootwear(cart.getFootwear());
			od.setSize(cart.getSize());
			od.setQuantity(cart.getQuantity());
			od.setAmount(cart.getAmount());
			orderDetailsRepo.save(od);
		}
		
		cartRepository.deleteAll(cartProducts);
		
		return "orderPlaced";
	}

}
