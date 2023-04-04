package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entities.Cart;
import com.demo.entities.User;
import com.demo.repository.CartRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	CartRepository cartRepository;
	
	@GetMapping("/cart")
	public String cart(Model model, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		Iterable<Cart> cartProducts = cartRepository.findByUser(user);
		model.addAttribute("cartProducts",cartProducts);
				
		double subTotal=0.0;
		double deliveryCharges = 0.0;
		double total=0.0;
		double discount = 0.0;
		
		for(Cart cart : cartProducts)
		{
			subTotal = subTotal + cart.getAmount();
		}
		
		total = subTotal + deliveryCharges - discount;
		
		model.addAttribute("subTotal", subTotal);
		model.addAttribute("deliveryCharges", deliveryCharges);
		model.addAttribute("total", total);
		model.addAttribute("discount", discount);
		
		return "cart";
	}
	
	@PostMapping("/addToCart")
	public String addtocart(@ModelAttribute Cart cart, Model model,HttpSession session)
	{
		
		double amount = cart.getQuantity() * cart.getFootwear().getPrice();
		cart.setAmount(amount);
		cartRepository.save(cart);
		model.addAttribute("msg" , "Your product has been added to cart.");
		if(cart.getFootwear().getIsMale().equals("m"))
			return "redirect:/menCollection";
		else
			return "redirect:/womenCollection";
				
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProductFromCart(@PathVariable (name = "id") int id)
	{
		cartRepository.deleteById(id);
		return "redirect:/cart";
	}
	
	@PostMapping("/checkout")
	public String checkout(Model model, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		Iterable<Cart> cartProducts = cartRepository.findByUser(user);
		model.addAttribute("cartProducts",cartProducts);
				
		double subTotal=0.0;
		double deliveryCharges = 0.0;
		double total=0.0;
		double discount = 0.0;
		
		for(Cart cart : cartProducts)
		{
			subTotal = subTotal + cart.getAmount();
		}
		
		total = subTotal + deliveryCharges - discount;
		
		model.addAttribute("subTotal", subTotal);
		model.addAttribute("deliveryCharges", deliveryCharges);
		model.addAttribute("total", total);
		model.addAttribute("discount", discount);
		return "checkout";
	}
	

}
