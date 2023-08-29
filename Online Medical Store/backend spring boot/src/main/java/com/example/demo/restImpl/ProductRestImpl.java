package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Product;
import com.example.demo.rest.ProductRest;
import com.example.demo.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ProductRestImpl implements ProductRest{

	@Autowired
	ProductService productService;
	
	@Override
	public ResponseEntity<String> addProduct(String productObj, MultipartFile file) {
		
		return productService.addProduct(productObj, file);
	}

	@Override
	public List<Product> getProducts() {
		
		return productService.getProducts();
	}

	@Override
	public ResponseEntity<String> deleteProduct(int id) {
		
		return productService.removeProduct(id);
	}

	@Override
	public ResponseEntity<String> updateProduct(String productObj, MultipartFile file) {
		
		return productService.updateProduct(productObj, file);
	}

	@Override
	public ResponseEntity<String> updateStatus(int id, Product product) {
		
		return productService.updateStatus(id, product);
	}

	@Override
	public List<Product> getActiveProducts() {
		
		return productService.getActiveProducts();
	}

	@Override
	public List<Product> getProductsByCategory(int category) {
		
		return productService.getProductsByCategory(category);
	}

	@Override
	public List<Product> getFewProducts() {
		
		return productService.getFewProducts();
	}

}
