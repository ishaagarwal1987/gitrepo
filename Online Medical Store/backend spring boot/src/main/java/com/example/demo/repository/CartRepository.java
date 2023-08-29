package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Cart;
import com.example.demo.Model.User;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> findByUser(User user);

}
