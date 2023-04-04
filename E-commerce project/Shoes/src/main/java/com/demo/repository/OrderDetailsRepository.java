package com.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.Footwear;
import com.demo.entities.OrderDetails;


public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer>{

	List<OrderDetails> findByFootwear(Footwear footwear);

	

}
