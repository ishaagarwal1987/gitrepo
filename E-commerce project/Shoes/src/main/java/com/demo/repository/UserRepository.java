package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	User findByUsernameAndPassword(String username, String password);

	User findByUsernameAndPasswordAndUserType(String username, String password, String userType);

	Iterable<User> findByUserType(String string);
	
}
