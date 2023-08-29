package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Orders;
import com.example.demo.Model.OrderDetail;
import com.example.demo.rest.OrderRest;
import com.example.demo.service.OrderService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class OrderRestImpl implements OrderRest{

	@Autowired
	OrderService orderService;
	
	@Override
	public Orders saveOrder(Orders order) {
		
		return orderService.saveOrder(order);
	}

	@Override
	public List<Orders> getOrderByUser(String user) {
		
		return orderService.getOrderByUser(user);
	}

	@Override
	public List<Orders> getOrders() {
		
		return orderService.getOrders();
	}

	@Override
	public List<OrderDetail> getOrderDetails(int id) {
		
		return orderService.getOrderDetails(id);
	}

}
