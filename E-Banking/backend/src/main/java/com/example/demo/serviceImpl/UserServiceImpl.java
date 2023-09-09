package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Utils.Utils;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User signup(User user) {
		try {
				
				return userRepository.save(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User login(String accountNo, String password) {
			//System.out.print("Account no. " + accountNo);	
		return userRepository.findByAccountNoAndPassword(Integer.parseInt(accountNo),password);
		//return null;
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updatePassword(int id, User user) {
		try {
			userRepository.save(user);
			return Utils.getResponseEntity("Password Updated Successfully.", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return Utils.getResponseEntity("Something Went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public User getUserByAccountNo(int accountno) {
		
		System.out.println("Account no. " + accountno);	
		return userRepository.findById(accountno).orElseThrow(null);
	}

	@Override
	public ResponseEntity<String> updateAuthorization(int id, User user) {
		try {
			userRepository.save(user);
			return Utils.getResponseEntity("Authorization Done Successfully.", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return Utils.getResponseEntity("Something Went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
