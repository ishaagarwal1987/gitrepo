package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Category;
import com.example.demo.Model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	List<Product> findByActiveStatus();

	List<Product> findByCategory(Category category);

	List<Product> findFewProducts();

}
