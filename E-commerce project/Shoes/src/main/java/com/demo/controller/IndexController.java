package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Footwear;
import com.demo.entities.User;
import com.demo.repository.FootWearRepository;


import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

	@Autowired
	private FootWearRepository footwearRepository;
	

	Footwear footwear;

	@GetMapping("/menCollection")
	public String menCollection(Model model) {
		Iterable<Footwear> footwears = footwearRepository.findByIsMale("m");
		model.addAttribute("footwears", footwears);
		model.addAttribute("msg", "");
		return "footwearCollection";
	}

	@GetMapping("/womenCollection")
	public String womenCollection(Model model) {
		Iterable<Footwear> footwears = footwearRepository.findByIsMale("f");
		model.addAttribute("footwears", footwears);
		model.addAttribute("msg", "");
		return "footwearCollection";
	}

	@GetMapping("/footwearDetail/{id}")
	public String updateForm(@PathVariable(value = "id") int id, Model model) {
		Optional<Footwear> optional = footwearRepository.findById(id);
		Footwear fc = optional.get();
		footwear = fc;
		return "redirect:/productDetail";
	}

	@GetMapping("/productDetail")
	public String updateform(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");

		model.addAttribute("footwear", footwear);
		
		if (user == null) {
			return "productDetail";
		} else {
			return "product";
		}
	}
	
	@PostMapping("/search")
	public String search(Model model,@RequestParam("searchString") String searchProduct)
	{
		
		return "redirect:/";
	}

}
