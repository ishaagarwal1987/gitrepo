package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Category;
import com.example.demo.rest.CategoryRest;
import com.example.demo.service.CategoryService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CategoryRestImpl implements CategoryRest{

	@Autowired
	CategoryService categoryService;
	
	@Override
	public ResponseEntity<String> addCategory(String category) {
		
		return categoryService.addCategory(category);
	}

	@Override
	public List<Category> getAllCategories() {
		
		return categoryService.getCategories();
	}

	@Override
	public ResponseEntity<String> removeCategory(int id) {
		
		return categoryService.removeCategory(id);
	}

	@Override
	public List<Category> updateCategory(int id, String category) {
		
		return categoryService.updateCategory(id, category);
	}

}
