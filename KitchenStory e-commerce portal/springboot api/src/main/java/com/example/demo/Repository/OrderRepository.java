package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Orders;
import com.example.demo.Model.User;

public interface OrderRepository extends CrudRepository<Orders, Integer>{

	List<Orders> findByUser(User user);

}
