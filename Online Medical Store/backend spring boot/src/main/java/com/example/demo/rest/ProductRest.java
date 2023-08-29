package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Product;


@RequestMapping(path="/products")
public interface ProductRest {
	
	@PostMapping
	public ResponseEntity<String> addProduct(@RequestParam("addProduct") String productObj,@RequestParam(value = "image") MultipartFile file);

	@GetMapping
	public List<Product> getProducts();
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") int id);
	
	@PostMapping("/update")
	public ResponseEntity<String> updateProduct(@RequestParam("updateProduct") String productObj,@RequestParam(value = "image") MultipartFile file);
	
	@PatchMapping("/{pid}")
	public ResponseEntity<String> updateStatus(@PathVariable(value = "pid") int id,@RequestBody Product product);
	
	@GetMapping("/active")
	public List<Product> getActiveProducts();
	
	@GetMapping("/few")
	public List<Product> getFewProducts();
	
	@GetMapping("/category/{category}")
	public List<Product> getProductsByCategory(@PathVariable(value = "category") int category);
	
}
