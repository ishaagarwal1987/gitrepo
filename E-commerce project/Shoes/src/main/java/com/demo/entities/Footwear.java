package com.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Footwear {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int footwear_id;
	private String name;
	private double price;
	private String brand;
	private String img_name;
	private String isMale;
	@ManyToOne(cascade = CascadeType.ALL)
	private FootwearCategory category;
		
	public Footwear() {
	}
	
	

	public Footwear(int footwear_id, String name, double price, String brand, String size, String img_name,
			String isMale, FootwearCategory category) {
		super();
		this.footwear_id = footwear_id;
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.img_name = img_name;
		this.isMale = isMale;
		this.category = category;
	}



	public void setFootwear_id(int footwear_id) {
		this.footwear_id = footwear_id;
	}



	public String getImg_name() {
		return img_name;
	}



	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}



	public int getFootwear_id() {
		return footwear_id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	public String getIsMale() {
		return isMale;
	}

	public void setIsMale(String isMale) {
		this.isMale = isMale;
	}

	public FootwearCategory getCategory() {
		return category;
	}

	public void setCategory(FootwearCategory category) {
		this.category = category;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	
}
