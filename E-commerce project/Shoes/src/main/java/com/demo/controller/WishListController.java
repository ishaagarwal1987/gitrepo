package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.entities.Footwear;
import com.demo.entities.User;
import com.demo.entities.WishList;
import com.demo.repository.FootWearRepository;
import com.demo.repository.WishListRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class WishListController {
	
	@Autowired
	private FootWearRepository footwearRepository;
	
	@Autowired
	private WishListRepository wishListRepository;
	
	@GetMapping("/addWishList")
	public String addWishList(HttpSession session,Model model)
	{
		String productId = (String) session.getAttribute("productId");
		int id = Integer.parseInt(productId);
		Optional<Footwear> optional = footwearRepository.findById(id);
		Footwear fc = optional.get();
		
		User user = (User) session.getAttribute("user");
		
		WishList wishList = new WishList();
		wishList.setFootwear(fc);
		wishList.setUser(user);
		
		wishListRepository.save(wishList);
		
		model.addAttribute("footwear", fc);
		model.addAttribute("msg", "Product added to WishList");
		return "product";
		
	}

}
