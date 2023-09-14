package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmailAndPassword(String emailId, String password);

	List<User> findByRole(String usertype);
}
