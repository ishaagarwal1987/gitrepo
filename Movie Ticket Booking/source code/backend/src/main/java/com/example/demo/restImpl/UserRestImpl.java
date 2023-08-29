package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;

import com.example.demo.rest.UserRest;
import com.example.demo.service.UserService;

import com.example.demo.utils.Utils;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class UserRestImpl implements UserRest{

	@Autowired
	UserService userService;
	
	@Override
	public ResponseEntity<String> signup(@RequestBody User user) {
		try {
			return userService.signup(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			return Utils.getResponseEntity("Something Went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public User login(String emailid, String password) {
		
		return userService.login(emailid, password);
	}

	@Override
	public List<User> getUsers() {
		
		return userService.getAllUsers();
	}

	@Override
	public ResponseEntity<String> updatePassword(int id, User user) {
		
		return userService.updatePassword(id, user);
	}

}
