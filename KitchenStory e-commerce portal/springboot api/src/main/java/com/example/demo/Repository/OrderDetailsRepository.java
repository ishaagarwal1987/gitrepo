package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.OrderDetails;
import com.example.demo.Model.Orders;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer>{

	List<OrderDetails> findByOrder(Orders order);

}
