package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.entities.Footwear;
import com.demo.entities.Stock;
import com.demo.entities.User;
import com.demo.repository.FootWearRepository;
import com.demo.repository.StockRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	String usertype, productId;
	
	@Autowired
	private FootWearRepository footwearRepository;
	
	@Autowired
	StockRepository stockRepository;

	@GetMapping("/")
	public String index() {

		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("userpage", "clientHome");
		return "login";
	}

	@GetMapping("/signup/{userType}")
	public String signup(@PathVariable(name = "userType") String usertype) {
		// System.out.print("usertype = " + usertype);
		// model.addAttribute("usertype", usertype);
		this.usertype = usertype;
		return "redirect:/signUp";
	}

	@GetMapping("/signUp")
	public String signUpPage(Model model) {
		model.addAttribute("usertype", this.usertype);
		return "signUp";
	}

	@GetMapping("/addCategory")
	public String addCategory() {
		return "addCategory";
	}

	@GetMapping("/clientLogin/{productId}")
	public String clientLogin(@PathVariable(name = "productId") String productId, Model model, HttpSession session) {

		this.productId = productId;
		return "redirect:/clientlogin";
	}

	@GetMapping("/clientlogin")
	public String client(Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			session.setAttribute("productId", productId);
			model.addAttribute("userpage", "product");
			return "login";
		}
		else {

			int id = Integer.parseInt(productId);
			Optional<Footwear> optional = footwearRepository.findById(id);
			Footwear fc = optional.get();
			Iterable<Stock> stocks = stockRepository.findByFootwear(fc);
			
			model.addAttribute("user", user);
			model.addAttribute("footwear", fc);
			model.addAttribute("stocks", stocks);
			return "product";
		}
	}

}
