package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Cart;
import com.example.demo.Model.User;

import jakarta.transaction.Transactional;

public interface CartRepository extends CrudRepository<Cart, Integer>{

	@Transactional
    @Modifying
	List<Cart> findAllByUser(User user);

	void deleteByUser(User user);

	@Transactional
	   @Modifying
	void deleteAllByUser(User user);

}
