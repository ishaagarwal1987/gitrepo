package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.User;

public interface UserService {

	ResponseEntity<String> signup(User user);
	User login(String emailId,String password);
	public List<User> getAllUsers();
	public ResponseEntity<String> updatePassword(int id,User user);
}
