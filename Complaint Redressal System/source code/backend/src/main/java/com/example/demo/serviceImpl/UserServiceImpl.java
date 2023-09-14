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
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public ResponseEntity<String> signup(User user) {
		try {
				userRepository.save(user);
				return Utils.getResponseEntity("SuccessFully Registered.", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return Utils.getResponseEntity("Someting Went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public User login(String emailId, String password) {
		User user =userRepository.findByEmailAndPassword(emailId,password);
		
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updatePassword(int id, User user) {
		try {
			userRepository.save(user);
			return Utils.getResponseEntity("Updated Successfully.", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return Utils.getResponseEntity("Something Went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<User> getUsersByUserType(String usertype) {
		
		return userRepository.findByRole(usertype);
	}

	@Override
	public ResponseEntity<String> deleteUser(int id) {
		userRepository.deleteById(id);
		return Utils.getResponseEntity("User Deleted Successfully.", HttpStatus.OK);
	}

	@Override
	public List<User> getEngineers() {
		
		return userRepository.findByRole("engineer");
	}

}
