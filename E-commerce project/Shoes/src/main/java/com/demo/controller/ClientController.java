package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Orders;
import com.demo.entities.User;
import com.demo.entities.WishList;
import com.demo.repository.OrdersRepository;
import com.demo.repository.UserRepository;
import com.demo.repository.WishListRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController {
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	private WishListRepository wishListRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	User user;
	
	@GetMapping("/viewClient")
	public String viewOrderClient(HttpSession session, Model model)
	{
		user = (User) session.getAttribute("user");
		
		Iterable<Orders> orders= ordersRepository.findByUser(user);
		
		Iterable<WishList> wishlists = wishListRepository.findByUser(user);
		
		model.addAttribute("orders", orders);
		model.addAttribute("wishlists", wishlists);
		
		return "clientHome";
	}

	@GetMapping("/deleteWishList/{id}")
	public String deleteWishList(@PathVariable(value = "id") int id)
	{
		wishListRepository.deleteById(id);
		return "redirect:/viewClient";
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestParam("password") String password)
	{
		user.setPassword(password);
		userRepository.save(user);
		return "redirect:/viewClient";
	}
	
	@GetMapping("/logoutClient")
	public String logoutClient(HttpSession session)
	{
		session.removeAttribute("user");
		session.removeAttribute("productId");
		return "redirect:/";
	}
}
