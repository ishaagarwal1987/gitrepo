package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
