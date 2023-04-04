package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.Orders;
import com.demo.entities.User;

public interface OrdersRepository extends CrudRepository<Orders, Integer>{


	Iterable<Orders> findByUser(User user);

	Iterable<Orders> findByCreatedOn(String date);

}
