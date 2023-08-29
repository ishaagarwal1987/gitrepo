package com.example.demo.service;

import java.util.List;

import com.example.demo.Model.Orders;
import com.example.demo.Model.OrderDetail;

public interface OrderService {

	public Orders saveOrder(Orders order);
	
	public List<Orders> getOrderByUser(String user);
	
	public List<Orders> getOrders();
	
	public List<OrderDetail> getOrderDetails(int id);
}
