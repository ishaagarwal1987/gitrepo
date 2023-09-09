package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.User;

public interface UserService {

	User signup(User user);
	
	User login(String accountNo,String password);
	
	public List<User> getAllUsers();
	
	public ResponseEntity<String> updatePassword(int id,User user);
	
	public User getUserByAccountNo(int accountno);
	
	public ResponseEntity<String> updateAuthorization(int id, User user);
	
}
