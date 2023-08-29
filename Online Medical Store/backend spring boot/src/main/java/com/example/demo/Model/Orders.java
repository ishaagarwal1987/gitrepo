package com.example.demo.Model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@DynamicUpdate
@Getter @Setter
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	
	@ManyToOne
	private User user;
	
	private String shippingAddress;
	private double totalAmount;
	private String createdOn; 
	private String status;
	private double discount;
	private double deliveryCharges;
	private double subTotal;
}
