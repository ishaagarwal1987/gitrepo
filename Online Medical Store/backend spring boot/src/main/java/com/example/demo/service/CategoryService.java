package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.example.demo.Model.Category;

public interface CategoryService {
	
	public ResponseEntity<String> addCategory(String category);
	
	public List<Category> getCategories();
	
	public ResponseEntity<String> removeCategory(int id);
	
	public List<Category> updateCategory(int id,String category);

}
