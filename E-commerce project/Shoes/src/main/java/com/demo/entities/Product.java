package com.demo.entities;

import org.springframework.web.multipart.MultipartFile;

public class Product {

	private int footwear_id;
	private String name;
	private double price;
	private String brand;
	private MultipartFile img_name;
	private String isMale;
	private FootwearCategory category;
	
	
	
	public Product() {
	}

	public Product(int footwear_id, String name, double price, String brand, String size, MultipartFile img_name,
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

	
	
	public int getFootwear_id() {
		return footwear_id;
	}

	public void setFootwear_id(int footwear_id) {
		this.footwear_id = footwear_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	public MultipartFile getImg_name() {
		return img_name;
	}

	public void setImg_name(MultipartFile img_name) {
		this.img_name = img_name;
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
	
	
	
	
	
}
