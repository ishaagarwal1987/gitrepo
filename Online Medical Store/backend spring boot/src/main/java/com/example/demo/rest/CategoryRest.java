package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Category;


@RequestMapping(path="/categories")
public interface CategoryRest {
	
	@PostMapping("/add")
	public ResponseEntity<String> addCategory(@RequestBody String category);
	
	@GetMapping
	public List<Category> getAllCategories();
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeCategory(@PathVariable(value = "id") int id);
	
	@PutMapping("/{id}")
	public List<Category> updateCategory(@PathVariable(value = "id") int id,@RequestBody String category);
	

}
