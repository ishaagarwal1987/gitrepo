package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Footwear;
import com.demo.entities.FootwearCategory;
import com.demo.entities.OrderDetails;
import com.demo.entities.Orders;
import com.demo.entities.User;
import com.demo.repository.FootWearRepository;
import com.demo.repository.FootwearCategoryRepository;
import com.demo.repository.OrderDetailsRepository;
import com.demo.repository.OrdersRepository;
import com.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrdersRepository orderRepository;
	
	@Autowired
	FootwearCategoryRepository categoryRepository;
	
	@Autowired
	private FootWearRepository footwearRepository;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepo;
	
	@GetMapping("/customerInfo")
	public String custInfo(Model model)
	{
		Iterable<User> customers = userRepository.findByUserType("client");
		model.addAttribute("customers", customers);
		return "customerInformation";
	}
	
	@GetMapping("/reportByDate")
	public String purchaseReportbyDate()
	{
		return "purchaseReportByDate";
	}
	
	@PostMapping("/sendDate")
	public String reportByDate(Model model,@RequestParam("date") String date)
	{
		Iterable<Orders> orders = orderRepository.findByCreatedOn(date);
		
		model.addAttribute("orders", orders);
	
		return "purchaseReportByDate";
	}
	
	@GetMapping("/reportByCategory")
	public String reportByCategory(Model model)
	{
		Iterable<FootwearCategory> categories =  categoryRepository.findAll();
		model.addAttribute("footwearCategories",categories);
		return "purchaseReportByCategory";
	}
	
	@PostMapping("/sendFootwearCategory")
	public String purchaseReportByCategory(Model model,@RequestParam("category") int id)
	{
		Optional<FootwearCategory> optional = categoryRepository.findById(id);
		FootwearCategory fc = optional.get();
		Iterable<Footwear> footwears = footwearRepository.findByCategory(fc);
	
		List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
		
		for(Footwear footwear : footwears)
		{
			List<OrderDetails> orderDetails1 = orderDetailsRepo.findByFootwear(footwear);
			orderDetails.addAll(orderDetails1);
		}
		
		Iterable<FootwearCategory> categories =  categoryRepository.findAll();
		model.addAttribute("footwearCategories",categories);
		model.addAttribute("orderDetails", orderDetails.iterator());
		return "purchaseReportByCategory";
	}
	
	@GetMapping("/changePasswordAdmin")
	public String changePasswordAdmin()
	{
		return "changePassword";
	}
	
	@PostMapping("/changepasswordAdmin")
	public String changepasswordAdmin(HttpSession session,@RequestParam("password") String password,Model model)
	{
		User user = (User) session.getAttribute("user");
		user.setPassword(password);
		userRepository.save(user);
		
		model.addAttribute("msg", "Password Updated");
		return "home";
	}

}
