package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.Cart;
import com.demo.entities.User;

public interface CartRepository extends CrudRepository<Cart, Integer>{

	Iterable<Cart> findByUser(User user);

}
