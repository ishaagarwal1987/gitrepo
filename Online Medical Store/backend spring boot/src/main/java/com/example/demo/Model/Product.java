package com.example.demo.Model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@NamedQuery(name = "Product.findByActiveStatus",query = "select p from Product p where p.status = true")
@NamedNativeQuery(name = "Product.findFewProducts" , query = "select * from product where status = true LIMIT 4", resultClass = Product.class)

@Data
@Entity
@DynamicUpdate
@Getter @Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String productname;
	private String brand;
	private double cost;
	private int quantity;
	@ManyToOne
	private Category category;
	private boolean status;
	private String image;

}
