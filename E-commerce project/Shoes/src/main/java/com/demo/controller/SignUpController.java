package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entities.User;
import com.demo.repository.UserRepository;

@Controller
public class SignUpController {
	
	@Autowired
	UserRepository userRepository;

	@PostMapping("/signupForm")
	public String signup(@ModelAttribute User user,Model model) {
		//user.setUserType("admin");
		userRepository.save(user);
		model.addAttribute("usertype", user.getUserType());
		return "login";
	}

}