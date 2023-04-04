package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Footwear;
import com.demo.entities.User;
import com.demo.repository.FootWearRepository;
import com.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	UserRepository userRepository;

	User user1;

	@Autowired
	private FootWearRepository footwearRepository;

	Footwear footwear;

	@PostMapping("/loginForm")
	public String signin(@ModelAttribute User user, Model model, HttpSession session,@RequestParam("userpage") String userpage) {

		user1 = userRepository.findByUsernameAndPasswordAndUserType(user.getUsername(), user.getPassword(),
				user.getUserType());

		if (user1 != null) {

			session.setAttribute("user", user1);
			if (user1.getUserType().equals("admin")) {
				model.addAttribute("msg", "");
				return "home";
			} else {
				if (userpage.equals("clientHome")) {
					return "redirect:/viewClient";
				} else {
					String productId = (String) session.getAttribute("productId");
					int id = Integer.parseInt(productId);
					Optional<Footwear> optional = footwearRepository.findById(id);
					Footwear fc = optional.get();
					footwear = fc;

					return "redirect:/product";
				}
			}
		}
		model.addAttribute("msg", "Sorry! Invalid username and password.");
		// session.setAttribute("msg", "Sorry! Invalid username and password.");
		return "index";
	}

	@GetMapping("/product")
	public String product(Model model) {
		model.addAttribute("user", user1);
		model.addAttribute("footwear", this.footwear);
		return "product";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("user");
		return "redirect:/";
	}

}
