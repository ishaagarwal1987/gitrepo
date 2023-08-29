package com.example.demo.serviceImpl;


import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.constants.MedicareConstants;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.MedicareUtils;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public ResponseEntity<String> signup(User user1) {
		try {
			User user  = userRepository.findByEmail(user1.getEmail());
			if(Objects.isNull(user))
			{
				userRepository.save(user1);
				return MedicareUtils.getResponseEntity("SuccessFully Registered.", HttpStatus.OK);
			}
			else
				return MedicareUtils.getResponseEntity("Email already exits.", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return MedicareUtils.getResponseEntity(MedicareConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public User login(String emailId,String password) {
		User user =userRepository.findBYEmailAndPassword(emailId,password);
		
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
			return MedicareUtils.getResponseEntity("Password Updated Successfully.", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return MedicareUtils.getResponseEntity(MedicareConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
