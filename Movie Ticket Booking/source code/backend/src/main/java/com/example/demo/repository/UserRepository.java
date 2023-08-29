package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	
	User findBYEmailAndPassword(String emailId, String password);

}
