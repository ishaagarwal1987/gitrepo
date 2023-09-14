package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.rest.UserRest;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class UserRestImpl implements UserRest{

	@Autowired
	UserService userService;
	
	@Override
	public ResponseEntity<String> signup(User user) {
		
		return userService.signup(user);
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

	@Override
	public List<User> getUsersByUserType(String usertype) {
		
		return userService.getUsersByUserType(usertype);
	}

	@Override
	public ResponseEntity<String> deleteUser(int id) {
		
		return userService.deleteUser(id);
	}

	@Override
	public List<User> getEngineers() {
		
		return null;
	}

}
