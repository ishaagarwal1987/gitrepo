package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Orders;
import com.example.demo.Model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{

	List<OrderDetail> findByOrder(Orders order);

}
