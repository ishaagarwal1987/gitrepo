package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Product;

public interface ProductService {

	public ResponseEntity<String> addProduct(String productObj, MultipartFile file);
	
	public List<Product> getProducts();
	
	public ResponseEntity<String> removeProduct(int id);
	
	public ResponseEntity<String> updateProduct(String productObj, MultipartFile file);
	
	public ResponseEntity<String> updateStatus(int id,Product product);
	
	public List<Product> getActiveProducts();
	
	public List<Product> getFewProducts();
	
	public List<Product> getProductsByCategory(int category);
	

}
